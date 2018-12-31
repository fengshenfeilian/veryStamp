package com.managementSystem.controller;

import com.managementSystem.dao.ShopMapper;
import com.managementSystem.pojo.*;
import com.managementSystem.service.ConsumerService;
import com.managementSystem.service.ShopService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @RequestMapping(value = "/showInfo")
    public String showInfo(Model model, HttpSession session, HttpServletRequest request)
    {
        Consumer consumer = (Consumer) session.getAttribute("currentConsumer");
        model.addAttribute("consumer",consumer);
        System.out.println("consumer login");
        return "/consumer/infoManager";
    }

    @RequestMapping(value = "/changepassword")
    public String changePassowrd(Model model,HttpSession session,HttpServletRequest request)
    {
        Consumer consumer = (Consumer) session.getAttribute("currentConsumer");
        model.addAttribute("consumer",consumer);
        return "/consumer/changepassword";
    }

    @RequestMapping(value = "/changepswd",method = RequestMethod.POST)
    public String updatepassword(@RequestParam(value = "now_password")String now_password,
                                 @RequestParam(value = "new_password")String new_password,
                                 @RequestParam(value = "re_new_password")String re_new_password,
                                Model model, HttpSession session, HttpServletRequest request)
    {
        Consumer consumer = (Consumer) session.getAttribute("currentConsumer");
        if (now_password.isEmpty() || new_password.isEmpty() || re_new_password.isEmpty())
        {
            model.addAttribute("message", "密码为空");
            return "/consumer/changepassword";
        }
        if(now_password.equals(consumer.getPassword()))
        {
            if(new_password.equals(re_new_password))
            {
                if(new_password.equals(now_password))
                {
                    return "redirect:/login.jsp";
                }
                else
                {
                    consumerService.changePassword(consumer,new_password);
                    model.addAttribute("message", "修改密码成功");
                    return "redirect:/login.jsp";
                }
            }
            else
            {
                model.addAttribute("message", "两次密码不一致");
                return "/consumer/changepassword";
            }
        }
        else
        {
            model.addAttribute("message", "原密码错误");
            return  "/consumer/changepassword";
        }

    }
    @RequestMapping(value = "/printShopOrder")
    public String listShopResource(Model model, HttpSession session, HttpServletRequest request)
    {
        Consumer consumer = (Consumer) session.getAttribute("currentConsumer");
        model.addAttribute("consumer",consumer);
        return "/consumer/listShopResource";
    }

    @RequestMapping(value = "/inquiry",method = RequestMethod.POST)
    public String inquiryResource( @RequestParam(value = "inquiry_resource_content") String resource_content,
                                    @RequestParam(value = "inquiry_shop_content") String shop_content,
                                    Model model,HttpSession session,HttpServletRequest request)
    {
        if(resource_content.isEmpty() && shop_content.isEmpty())
        {
            return "/consumer/listShopResource";
        }
        if(resource_content.isEmpty() && !shop_content.isEmpty())
        {

        }
        if(!resource_content.isEmpty() && shop_content.isEmpty())
        {

        }
        if(!resource_content.isEmpty() && !shop_content.isEmpty()) {

        }
        return "/consumer/listShopResource";
    }

    @RequestMapping(value = "/printMyOrder")
    public String printSelfFile(Model model,HttpSession session,HttpServletRequest request)
    {
        Consumer consumer = (Consumer) session.getAttribute("currentConsumer");
        model.addAttribute("consumer",consumer);
        List<Shop> shopNameList = consumerService.getAll();
        model.addAttribute("shopNameList", shopNameList);
        return "/consumer/printSelfFile";
    }

    @RequestMapping(value = "/myOrder")
    public String listSelfOrder(Model model,HttpSession session,HttpServletRequest request)
    {
        Consumer consumer = (Consumer) session.getAttribute("currentConsumer");
        model.addAttribute("consumer",consumer);

        List<Order_List> order_lists = consumerService.getOrdersByConsumerId(consumer.getConsumerId());
        for(Order_List order_list:order_lists)
        {
            String resourceName = consumerService.getResourceNameByResId(order_list.getResId());
            order_list.setResourceName(resourceName);
            String shopName = consumerService.getShopNameByShopId(order_list.getShopId());
            order_list.setShopId(shopName);
        }
        model.addAttribute("orders",order_lists);
        return "/consumer/myOrderList";
    }

    @RequestMapping(value = "/showcredit")
    public String showCredit(Model model,HttpSession session,HttpServletRequest request)
    {
        Consumer consumer = (Consumer) session.getAttribute("currentConsumer");
        model.addAttribute("consumer",consumer);
        System.out.println(consumer.getConsumerId());
        Consumer_Credit consumer_credit = consumerService.getConsumerCredit(consumer.getConsumerId());
        if(consumer_credit != null){
            model.addAttribute("consumer_credit",consumer_credit);
        }
        List<Order_List> orderLists = consumerService.getOrdersByConsumerId(consumer.getConsumerId());
        if(orderLists != null){
            model.addAttribute("orders",orderLists);
        }
        return "/consumer/credit";
    }

    @RequestMapping(value = "/addMission",method = RequestMethod.POST)
    public String addMission(@RequestParam(value = "printLayout")String printLayout,
                             @RequestParam(value = "printNumber")String printNumber,
                             @RequestParam(value = "printShop")String printShopId,
                             @RequestParam(value = "getTime") String  getTime,
                             @RequestParam(value = "filename") MultipartFile  file,
                             Model model, HttpSession session, HttpServletRequest request) {
        Consumer consumer = (Consumer) session.getAttribute("currentConsumer");

        Resource resource = new Resource();
        resource.setResType("consumer");
        resource.setShopId(printShopId);
        resource.setResName(file.getOriginalFilename());
        resource.setResId(file.getOriginalFilename()+consumer.getConsumerId());

        String resId = consumerService.addResource(resource);

        System.out.println(resId);

        consumerService.saveFile(file);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date takeTime = sdf.parse(getTime);

            Order_List orderList = new Order_List();
            orderList.setShopId(printShopId);
            orderList.setUserId(consumer.getConsumerId());
            orderList.setPrintFormat(printLayout);
            orderList.setPrintCount(Integer.parseInt(printNumber));
            orderList.setResourceName(file.getOriginalFilename());
            orderList.setState("toPrint");
            Date now = new Date();
            orderList.setOrderTime(now);
            orderList.setTargetTakeTime(takeTime);
            orderList.setOrderId(String.valueOf(now.getTime()));
            orderList.setResId(resId);

            consumerService.addOrder(orderList);
            session.setAttribute("message", "提交成功");
            return "/consumer/printSelfFile";
        } catch (Exception e) {
            System.out.println(e);
            return "/consumer/printSelfFile";
        }
    }


}
