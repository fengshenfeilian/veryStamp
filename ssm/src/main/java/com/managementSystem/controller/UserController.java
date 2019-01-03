package com.managementSystem.controller;

import com.managementSystem.pojo.*;
import com.managementSystem.service.UserService;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    UserService userService;

    //进入登录界面
    @RequestMapping(value = "/loginPage")
    public String goLoginPage()
    {
        return "redirect:/login.jsp";
    }

    //进入联系我们界面
    @RequestMapping(value = "/contactPage")
    public String goContact(Model model)
    {
        Company_Info companyInfo = userService.getCompanyInfoById("777");
        model.addAttribute("companyInfo",companyInfo);

        return "contactPage";
    }

    //默认进入普通用户注册界面
    @RequestMapping(value = "/registerPage")
    public String goRegister()
    {
        return "registerPage";
    }
    //进入商户注册界面
    @RequestMapping(value = "/shopRegisterPage")
    public String goShopRegister()
    {
        return "shopRegisterPage";
    }

    /*
    注册的业务逻辑
        1.用户注册，主键为邮箱号
        2.邮箱号在admin、shop、consumer三张表中均唯一
    */
    //普通用户注册
    @RequestMapping(value = "/consumerRegister",method = RequestMethod.POST)
    public String consumerRegister(@RequestParam(value = "emailValid")String userId,
                                   @RequestParam(value = "userName")String userName,
                                   @RequestParam(value = "numsValid")String phone,
                                   @RequestParam(value = "address")String address,
                                   @RequestParam(value = "password1")String password,
                                   Model model,HttpSession session,HttpServletRequest request)
    {
        //若admin、shop、consumer中存在userId,则注册失败，返回注册界面
        Admin admin = userService.getAdminById(userId);
        Shop shop= userService.getShopById(userId);
        Consumer consumer = userService.getConsumerById(userId);
        if((admin != null) || (shop != null) || consumer != null){
            model.addAttribute("message","该邮箱已被注册");
            return "redirect:/user/registerPage";
        }
        //若consumer中存在相同用户名，则注册失败，返回注册界面
        List<Consumer> consumerList = userService.getConsumerByName(userName);
        if(!consumerList.isEmpty()){
            model.addAttribute("message","该用户名已被注册");
            return "redirect:/user/registerPage";
        }
        //合法账号，向Consumer表中插入记录
        Consumer newConsumer = new Consumer();
        newConsumer.setConsumerId(userId);
        newConsumer.setPhone(phone);
        newConsumer.setAddress(address);
        newConsumer.setPassword(password);
        newConsumer.setUserName(userName);

        userService.insertConsumer(newConsumer);
        //插入ConsumerCredit
        Consumer_Credit credit = new Consumer_Credit();
        credit.setConsumerId(newConsumer.getConsumerId());
        credit.setCredit(0);
        userService.insertConsumerCredit(credit);
        //注册成功，返回登录界面
        return "redirect:/login.jsp";
    }

    //商户注册
    @RequestMapping(value = "/shopRegister", method = RequestMethod.POST)
    public String shopRegister(@RequestParam(value = "emailValid")String userId,
                               @RequestParam(value = "userName")String userName,
                               @RequestParam(value = "numsValid")String phone,
                               @RequestParam(value = "address")String address,
                               @RequestParam(value = "password1")String password,
                               @RequestParam(value = "startTime")String startTime,
                               @RequestParam(value = "endTime")String endTime,
                               @RequestParam(value = "singlePagePrice") String singlePagePrice,
                               @RequestParam(value = "doublePagePrice") String doublePagePrice,
                               Model model,HttpSession session,HttpServletRequest request
                               )
    {
        //若admin、shop、consumer中存在userId,则注册失败，返回注册界面
        Admin admin = userService.getAdminById(userId);
        Shop shop= userService.getShopById(userId);
        Consumer consumer = userService.getConsumerById(userId);
        if((admin != null) || (shop != null) || consumer != null){
            model.addAttribute("message","该邮箱已被注册");
            return "redirect:/user/shopRegisterPage";
        }
        //若shop中存在相同商户名，则注册失败，返回注册界面
        List<Shop> shopList = userService.getShopByName(userName);
        if(!shopList.isEmpty()){
            model.addAttribute("message","该商户名已被注册");
            return "redirect:/user/shopRegisterPage";
        }
        //创建商户
        Shop newShop = new Shop();
        newShop.setAddress(address);
        newShop.setBusinessEndTime(endTime);
        newShop.setBusinessStartTime(startTime);
        newShop.setPassword(password);
        newShop.setPhone(phone);
        newShop.setShopId(userId);
        newShop.setUserName(userName);
        Date date = new Date();
        newShop.setSignupTime(date);
        userService.insertShop(newShop);

        //创建商户账户
        Shop_Credit credit = new Shop_Credit();
        credit.setShopId(newShop.getShopId());
        credit.setCredit(0);
        userService.insertShopCredt(credit);

        Shop_Price shop_price = new Shop_Price();
        shop_price.setShopId(newShop.getShopId());
        if(singlePagePrice != null)
        {
            try {
                shop_price.setSinglePagePrice(new BigDecimal(Double.parseDouble(singlePagePrice)));
            }
            catch(Exception e){
                model.addAttribute("message", "价格格式错误");
                model.addAttribute("shop", shop);
                return "redirect:/user/shopRegisterPage";
            }
        }
        if(doublePagePrice != null)
        {
            try {
                shop_price.setDoublePagePrice(new BigDecimal(Double.parseDouble(doublePagePrice)));
            }
            catch(Exception e){
                model.addAttribute("message", "价格格式错误");
                model.addAttribute("shop", shop);
                return "redirect:/user/shopRegisterPage";
            }
        }
        userService.insertShopPrice(shop_price);
        //注册成功，返回登录界面
        return "redirect:/login.jsp";
    }

    //登录校验
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String modifyInfo(@RequestParam(value = "userId")String userId,
                             @RequestParam(value = "password")String password,
                             Model model, HttpSession session, HttpServletRequest request)
    {
        //商户登陆校验
        Shop shop = userService.getShop(userId,password);
        if( shop != null) {
            //把user信息存储到session中
            request.getSession().setAttribute("currentShop", shop);
            //跳转至infoManager.jsp
            return "redirect:/shop/showInfo";
        }
        //普通用户登陆校验
        Consumer consumer = userService.getConsumer(userId,password);
        if(consumer != null ){
            System.out.println("consumer success");
            request.getSession().setAttribute("currentConsumer",consumer);
            return "redirect:/consumer/showInfo";
        }
        //管理员用户登录校验
        Admin adminUser = userService.getAdminUser(userId,password);
        if(adminUser != null){
            request.getSession().setAttribute("currentAdmin",adminUser);
            return "redirect:/admin/home";
        }
        model.addAttribute("message","用户名或密码错误");
        return "redirect:/login.jsp";
    }

}
