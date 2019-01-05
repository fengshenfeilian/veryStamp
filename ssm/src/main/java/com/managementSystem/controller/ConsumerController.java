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
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

//待打印订单 -- 增加按钮【撤销订单】
//待取货订单 -- 增加按钮【完成订单】
/*
    修订【订单价格】（showcredit、addMission、createShopResOrder）
        -用户上传资源 : 每页价格 * 页面类型系数 * 单份页数 * 总份数
        -店家资源 ： 单份价格 * 总份数
*/


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
        //店家资源列表
        List<Resource> resourceList = consumerService.getShopResourceList();
        model.addAttribute("resourceList",resourceList);
        //根据资源列表获取店家列表
        List<Shop> shopList = consumerService.getShopListByResourceList(resourceList);
        model.addAttribute("shopList",shopList);

        return "/consumer/listShopResource";
    }

    @RequestMapping(value = "/shopResPrint")
    public String goShopResPrint(Model model, HttpSession session, HttpServletRequest request)
    {
        String resId = request.getParameter("resId");
        Resource resource = consumerService.getResourceById(resId);
        model.addAttribute("resource",resource);
        if(!resource.getShopId().isEmpty()){
            Shop shop = consumerService.getShopByResId(resource.getShopId());
            model.addAttribute("shop",shop);
        }

        Consumer consumer = (Consumer) session.getAttribute("currentConsumer");
        model.addAttribute("consumer",consumer);
        return "consumer/shopResPrintPage";
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
        List<Order_List> toPrintOrderList = consumerService.getToPrintOrderList(consumer.getConsumerId());
        List<Order_List> toReceiveOrderList = consumerService.getToReceiveOrderList(consumer.getConsumerId());
        List<Order_List> completeOrderList = consumerService.getCompleteOrderList(consumer.getConsumerId());

        model.addAttribute("toPrintOrderList",toPrintOrderList);
        model.addAttribute("toReceiveOrderList",toReceiveOrderList);
        model.addAttribute("completeOrderList",completeOrderList);

        List<Resource> toPrintResList = consumerService.getResListByOrderList(toPrintOrderList);
        List<Resource> toReceiveResList = consumerService.getResListByOrderList(toReceiveOrderList);
        List<Resource> completeResList = consumerService.getResListByOrderList(completeOrderList);

        model.addAttribute("toPrintResList",toPrintResList);
        model.addAttribute("toReceiveResList",toReceiveResList);
        model.addAttribute("completeResList",completeResList);


        return "/consumer/myOrderList";
    }


    //以商户资源创建订单
    @RequestMapping(value = "/createShopResOrder", method = RequestMethod.POST)
    public String goCreateShopResOrder(Model model, HttpSession session, HttpServletRequest request)
    {
        System.out.println("begin");
        //获取当前用户
        Consumer consumer = (Consumer) session.getAttribute("currentConsumer");
        //获取资源
        String resId = request.getParameter("resId");
        Resource resource = consumerService.getResourceById(resId);
        //获取打印格式
        String layout = request.getParameter("printLayout");
        String number = request.getParameter("printNumber");
        String getTime = request.getParameter("getTime");
        getTime = getTime.replace('T', ' ') + ":00";

        Date curDateTime = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String curDateTimeStr = df.format(curDateTime);
        //取货时间不合法，则订单创建失败,跳转回商户资源列表
        if(getTime.compareTo(curDateTimeStr) < 0){
            model.addAttribute("message","取货时间不能早于当前时间");
            return "redirect:/consumer/printShopOrder";
        }
        //若订单创建成功，则返回订单列表
        try{
            System.out.println("addOrder");
            Order_List order = new Order_List();
            order.setOrderId(resId + ' ' + consumer.getConsumerId() + ' ' + resource.getShopId() + ' ' + curDateTimeStr);
            order.setShopId(resource.getShopId());
            order.setUserId(consumer.getConsumerId());
            order.setResId(resource.getResId());
            order.setPrintFormat(layout);
            order.setPrintCount(Integer.parseInt(number));
            order.setTotalPageCount(order.getPrintCount()*Integer.parseInt(number));
            order.setTotalPrice(resource.getTotalPrice().doubleValue() * order.getPrintCount());
            order.setOrderTime(curDateTime); //下单时间 = 当前时间
            order.setState("等待打印"); //订单状态  = 等待打印
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date targetTakeTime = sdf.parse(getTime);
            System.out.println(targetTakeTime.toString());
            order.setTargetTakeTime(targetTakeTime);
            System.out.println("begin to addOrder");
            System.out.println(order.getResId());
            consumerService.addOrder(order);
            session.setAttribute("message", "订单创建成功");
            return "redirect:/consumer/myOrder";
        }catch (Exception e){
            model.addAttribute("message","订单创建失败");
            return "redirect:/consumer/printShopOrder";
        }

    }

    //以用户上传资源创建订单
    @RequestMapping(value = "/addMission",method = RequestMethod.POST)
    public String addMission(@RequestParam(value = "printLayout")String printLayout,
                             @RequestParam(value = "printNumber")String printNumber,
                             @RequestParam(value = "printShop")String printShopId,
                             @RequestParam(value = "getTime") String getTime,
                             @RequestParam(value = "filename") MultipartFile file,
                             Model model, HttpSession session, HttpServletRequest request) {
        Consumer consumer = (Consumer) session.getAttribute("currentConsumer");
        Date curDateTime = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String curDateTimeStr = df.format(curDateTime);
        getTime = getTime.replace('T', ' ') + ":00";
        //取货时间不合法，则订单创建失败
        if(getTime.compareTo(curDateTimeStr) < 0){
            model.addAttribute("message","取货时间不能早于当前时间");
            return "redirect:/consumer/printSelfFile";
        }
        //ResId : 下单时间 + 文件名
        String resId = file.getOriginalFilename() + ' ' + consumer.getConsumerId();
        String resType = "consumer";
        //创建(用户创建的)Resource对象
        Resource resource = new Resource();
        resource.setResName(file.getOriginalFilename());
        resource.setResId(resId);
        resource.setResType(resType);
        try {
            //插入Resource记录
            consumerService.addResource(resource);
            //创建资源文件目录
            consumerService.saveFile(file);
            //插入Order记录
            Order_List order = new Order_List();
            //orderId = resId + consumerId + shopId
            order.setOrderId(resId + ' ' + consumer.getConsumerId() + ' ' + printShopId + ' ' +curDateTimeStr);
            order.setShopId(printShopId);
            order.setUserId(consumer.getConsumerId());
            order.setResId(resource.getResId());
            order.setPrintFormat(printLayout);
            order.setPrintCount(Integer.parseInt(printNumber));
            order.setOrderTime(curDateTime); //下单时间 = 当前时间
            order.setState("等待打印"); //订单状态  = 等待打印
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date targetTakeTime = sdf.parse(getTime);
            order.setTargetTakeTime(targetTakeTime);
            consumerService.addOrder(order);
            session.setAttribute("message", "订单创建成功");
            return "redirect:/consumer/myOrder";
        } catch (Exception e) {
            session.setAttribute("message", "订单创建失败");
            return "redirect:/consumer/printSelfFile";
        }
    }

    //单笔充值不能超过5000元
    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    public String goRecharge(Model model, HttpServletRequest request, HttpSession session)
    {
        String moneyStr = request.getParameter("numsValid");
        if(moneyStr.length() > 4){
            model.addAttribute("message","单笔充值超过限额");
            return "redirect:/consumer/showcredit";
        }
        Integer money = Integer.parseInt(moneyStr);
        if(money.compareTo(5000) > 0){
            model.addAttribute("message","单笔充值超过限额");
        }
        else{
            Consumer consumer = (Consumer) session.getAttribute("currentConsumer");
            if(consumerService.updateConsumerCredit(consumer,money) == true){
                model.addAttribute("message","充值成功");
            }else{
                model.addAttribute("message","充值失败");
            }
        }
        return "redirect:/consumer/showcredit";
    }

    @RequestMapping(value = "/showcredit")
    public String showCredit(Model model,HttpSession session,HttpServletRequest request)
    {
        Consumer consumer = (Consumer) session.getAttribute("currentConsumer");
        model.addAttribute("consumer",consumer);
        Consumer_Credit consumer_credit = consumerService.getConsumerCredit(consumer.getConsumerId());
        if(consumer_credit != null){
            model.addAttribute("consumer_credit",consumer_credit);
        }
        //获取已完成订单
        List<Order_List> orderLists = consumerService.getCompleteOrderList(consumer.getConsumerId());
        if(orderLists != null){
            model.addAttribute("orders",orderLists);
        }
        //计算得到订单价格

        return "/consumer/credit";
    }

    @RequestMapping(value = "/confirmReceipt")
    public String goConfirmReceipt(HttpServletRequest request, HttpSession session, Model model)
    {
        String orderId = request.getParameter("orderId");
        Order_List order = consumerService.getOrderByOrderId(orderId);
        Consumer consumer = (Consumer) session.getAttribute("currentConsumer");
        Consumer_Credit credit = consumerService.getConsumerCredit(consumer.getConsumerId());
        //判断是否可以扣费
        if(credit.getCredit() < order.getTotalPrice().intValue()){
            model.addAttribute("message","账户余额不足，请充值");
        }
        //确认收货 ：扣费并修改订单状态为已完成
        else{
            //扣费
            consumerService.minusConsumerCredit(credit,order.getTotalPrice().intValue());
            //修改订单状态
            consumerService.updateOrderState(order,"已完成");
            //删除res
            String resid = order.getResId();
            if(consumerService.getResourceById(resid).getResType().equals("consumer"))
                consumerService.deleteResById(resid);
        }
        return "redirect:/consumer/myOrder";
    }
    //撤销订单
    @RequestMapping(value = "/cancelOrder")
    public String goCancelReceipt(HttpServletRequest request, HttpSession session, Model model)
    {
        String orderId = request.getParameter("orderId");
        String resId = consumerService.getOrderByOrderId(orderId).getResId();
        consumerService.deleteOrderById(orderId);
        consumerService.deleteResById(resId);
        return "redirect:/consumer/myOrder";
    }

}
