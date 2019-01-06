package com.managementSystem.controller;


import com.managementSystem.pojo.Order_List;
import com.managementSystem.pojo.Resource;
import com.managementSystem.pojo.Shop;
import com.managementSystem.pojo.Shop_Price;
import com.managementSystem.service.ConsumerService;
import com.managementSystem.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @Autowired
    ConsumerService consummerService;

    @RequestMapping(value = "/showInfo")
    public String showInfo(Model model, HttpSession session, HttpServletRequest request)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        Shop_Price shop_price = shopService.getShopPrice(shop.getShopId());
        model.addAttribute("shop_price", shop_price);
        model.addAttribute("shop", shop);
        return "shop/infoManager";
    }

    @RequestMapping(value = "/goModifyInfo")
    public String goModifyInfo(Model model, HttpSession session, HttpServletRequest request)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        model.addAttribute("shop", shop);
        return "shop/modifyInfo";
    }

    @RequestMapping(value = "/modifyInfo", method = RequestMethod.POST)
    public String modifyInfo(@RequestParam(value = "oldPassword")String oldPassword,
                             @RequestParam(value = "password")String password,
                             @RequestParam(value = "confirmPassword") String confirmPassword,
                             @RequestParam(value = "phone") String phone,
                             @RequestParam(value = "address") String address,
                             @RequestParam(value = "businessStartTime") String businessStartTime,
                             @RequestParam(value = "businessEndTime") String businessEndTime,
                             @RequestParam(value = "singlePagePrice") String singlePagePrice,
                             @RequestParam(value = "doublePagePrice") String doublePagePrice,
                             Model model, HttpSession session, HttpServletRequest request)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        if(oldPassword != null && !(oldPassword.equals("")) && !(shop.getPassword().equals(oldPassword)))
        {
            model.addAttribute("message", "原密码错误");
            return "shop/modifyInfo";
        }
        else if(!(password.equals(confirmPassword)))
        {
            model.addAttribute("message", "前后密码不一致");
            return "shop/modifyInfo";
        }
        if(password != null && !(password.equals("")))
        {
            shop.setPassword(password);
        }
        if(phone != null && !(phone.equals(""))) shop.setPhone(phone);
        if(address != null && !(address.equals(""))) shop.setAddress(address);
        if(businessStartTime != null && !(businessStartTime.equals(""))) shop.setBusinessStartTime(businessStartTime);
        if(businessEndTime != null && !(businessEndTime.equals(""))) shop.setBusinessEndTime(businessEndTime);
        Shop_Price shop_price = shopService.getShopPrice(shop.getShopId());
        if(singlePagePrice != null && !(singlePagePrice.equals("")))
        {
            try {
                shop_price.setSinglePagePrice(new BigDecimal(Double.parseDouble(singlePagePrice)));
            }
            catch(Exception e){
                model.addAttribute("message", "价格格式错误");
                model.addAttribute("shop", shop);
                return "shop/infoManager";
            }
        }
        if(doublePagePrice != null && !(doublePagePrice.equals("")))
        {
            try {
                shop_price.setDoublePagePrice(new BigDecimal(Double.parseDouble(doublePagePrice)));
            }
            catch(Exception e){
                model.addAttribute("message", "价格格式错误");
                model.addAttribute("shop", shop);
                return "shop/infoManager";
            }
        }
        shopService.updateShopPrice(shop_price);
        shopService.updateShop(shop);
        model.addAttribute("shop", shop);
        model.addAttribute("shop_price", shop_price);
        return "shop/infoManager";
    }

    @RequestMapping(value = "/showToPrintOrder")
    public String showToReceiveOrder(Model model, HttpSession session)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        System.out.println(shop.getUserName());
        List<Order_List> order_lists = shopService.getOrdersByState(shop.getShopId(), "等待打印");
//        if(order_lists.isEmpty())
//        {
//            model.addAttribute("message", "当前没有需打印的订单");
//            model.addAttribute("shop", shop);
//            return "shop/toReceiveOrder";
//        }
        for(Order_List order_list : order_lists)
        {
            order_list = consummerService.convertOrder(order_list);
        }
        model.addAttribute("orders",order_lists);
        model.addAttribute("shop", shop);
        return "shop/toReceiveOrder";
    }

    @RequestMapping(value = "/showToReceiveOrder")
    public String showUncompletedOrder(Model model, HttpSession session)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        List<Order_List> order_lists = shopService.getOrdersByState(shop.getShopId(), "待取货");
//        if(order_lists.isEmpty())
//        {
//            model.addAttribute("message", "当前没有需领取的订单");
//            model.addAttribute("shop", shop);
//            return "shop/uncompletedOrder";
//        }
        for(Order_List order_list : order_lists)
        {
            order_list = consummerService.convertOrder(order_list);
        }
        model.addAttribute("orders",order_lists);
        model.addAttribute("shop", shop);
        return "shop/uncompletedOrder";
    }

    @RequestMapping(value = "/showCompletedOrder")
    public String showCompletedOrder(Model model, HttpSession session)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        List<Order_List> order_lists = shopService.getOrdersByState(shop.getShopId(), "已完成");
//        if(order_lists.isEmpty())
//        {
//            model.addAttribute("message", "当前没有已完成的订单");
//            model.addAttribute("shop", shop);
//            return "shop/completedOrder";
//        }
        for(Order_List order_list : order_lists)
        {
            order_list = consummerService.convertOrder(order_list);
        }
        model.addAttribute("orders",order_lists);
        model.addAttribute("shop", shop);
        return "shop/completedOrder";
    }

    @RequestMapping(value = "/confirmReceive")
    public String confirmReceive(@RequestParam(value="orderId") String orderId, Model model, HttpSession session)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        shopService.updateOrderState(orderId, "待取货");
        List<Order_List> order_lists = shopService.getOrdersByState(shop.getShopId(), "等待打印");
//        if(order_lists.isEmpty())
//        {
//            model.addAttribute("message", "当前没有需打印的订单");
//            model.addAttribute("shop", shop);
//            return "shop/toReceiveOrder";
//        }
        for(Order_List order_list : order_lists)
        {
            order_list = consummerService.convertOrder(order_list);
        }
        model.addAttribute("orders",order_lists);
        model.addAttribute("shop", shop);
        return "shop/toReceiveOrder";
    }

    public Order_List addPrice(Order_List order_list, String shopId, int pageCount)
    {
        order_list.setTotalPageCount(order_list.getPrintCount()*pageCount);
        //查找用户资源的单张纸价格
        Shop_Price shop_price = shopService.getShopPrice(shopId);
        if(order_list.getPrintFormat().equals("single"))
        {
            order_list.setTotalPrice(shop_price.getSinglePagePrice().doubleValue() * order_list.getTotalPageCount());
        }
        else
        {
            order_list.setTotalPrice(shop_price.getDoublePagePrice().doubleValue() * order_list.getTotalPageCount() / 2);
        }
        return order_list;
    }

    @RequestMapping(value = "/modifyPageCount", method = RequestMethod.POST)
    public String confirmComplete(@RequestParam(value="orderId") String orderId,
                                  @RequestParam(value="pageCount") String pageCount,
                                  Model model, HttpSession session)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        Order_List order_list = shopService.getOrderById(orderId);
        if(order_list == null)
        {
            model.addAttribute("message", "该订单不存在");
        }
        else
        {
            order_list = addPrice(order_list, shop.getShopId(), Integer.parseInt(pageCount));
            shopService.updateOrder(order_list);
        }
//        shopService.updateOrderState(orderId, "completed");
        List<Order_List> order_lists = shopService.getOrdersByState(shop.getShopId(), "等待打印");
//        if(order_lists.isEmpty())
//        {
//            model.addAttribute("message", "当前没有需打印的订单");
//            model.addAttribute("shop", shop);
//            return "shop/toReceiveOrder";
//        }
        for(Order_List order_list1 : order_lists)
        {
            order_list1 = consummerService.convertOrder(order_list1);
        }
        model.addAttribute("orders",order_lists);
        model.addAttribute("shop", shop);
        return "shop/toReceiveOrder";
    }

    @RequestMapping(value = "/showResources")
    public String showResources(Model model, HttpSession session)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        List<Resource> resources = shopService.getResources(shop.getShopId(), "shop");
        model.addAttribute("resources", resources);
        model.addAttribute("shop", shop);
        return "shop/resourceManager";
    }

    @RequestMapping(value = "/goAddResource")
    public String goAddResource(Model model, HttpSession session)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        model.addAttribute("shop", shop);
        List<Resource> resources = shopService.getResources(shop.getShopId(), "shop");
        model.addAttribute("resources", resources);
        return "shop/addResource";
    }

    @RequestMapping(value = "/deleteResource")
    public String deleteResource(@RequestParam(value = "resourceId") String resourceId,Model model, HttpSession session)
    {
        shopService.deleteResource(resourceId);
        model.addAttribute("message", "已删除");
        Shop shop = (Shop) session.getAttribute("currentShop");
        List<Resource> resources = shopService.getResources(shop.getShopId(), "shop");
        model.addAttribute("resources", resources);
        model.addAttribute("shop", shop);
        return "shop/resourceManager";
    }

    @RequestMapping(value = "/shopStatistics")
    public String showStatistics(Model model, HttpSession session)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        model.addAttribute("shop", shop);
        return "shop/statistics";
    }

    @RequestMapping(value = "/addResource", method = RequestMethod.POST)
    public String addResource(@RequestParam(value = "filename") MultipartFile file,
                              @RequestParam(value = "resName") String resName,
                              @RequestParam(value = "pageCount") String pageCount,
                              @RequestParam(value = "description") String description,
                              @RequestParam(value = "price") String price,
                              HttpSession session, Model model)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        if(file == null)
        {
            model.addAttribute("message", "未选择文件");
        }
        else
        {
            String name = file.getOriginalFilename();
            //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
            long size=file.getSize();
            if(name==null || ("").equals(name) && size==0)
            {
                model.addAttribute("message", "未选择文件");
            }
            else
            {
//                shopService.saveResource(name, file);
                consummerService.saveFile(file);
                Resource resource = new Resource();
                resource.setResName(resName);
                resource.setShopId(shop.getShopId());
                resource.setResId(resName+shop.getShopId());
                resource.setDescription(description);
                resource.setPageCount(Integer.parseInt(pageCount));
                resource.setTotalPrice(new BigDecimal(Double.parseDouble(price)));
                resource.setResType("shop");
                shopService.insertResource(resource);
                model.addAttribute("message", "上传成功");
            }
        }
        List<Resource> resources = shopService.getResources(shop.getShopId(), "shop");
        model.addAttribute("resources", resources);
        model.addAttribute("shop", shop);
        return "shop/resourceManager";
    }

    @RequestMapping(value = "/selectStatistic")
    public String selectStatistic(@RequestParam("year") String year,
                                  @RequestParam("month") String month,
                                  HttpSession session, Model model)
    {
        Shop shop = (Shop)session.getAttribute("currentShop");
        model.addAttribute("shop", shop);
        List<Order_List> order_lists = shopService.getOrdersByState(shop.getShopId(), "已完成");
        int num = 0;
        double price = 0.0;
        for (Order_List order_list : order_lists)
        {
            Date t = order_list.getFinishTime();
//            Calendar c = Calendar.getInstance();
////            c.setTime(t);
////            System.out.println(t.toString());
////            int y = c.get(Calendar.YEAR);
////            int m = c.get(Calendar.MONTH);
            String y = String.format("%tY", t);
            String m = String.format("%tm", t);
            System.out.println(y);
            System.out.println(m);
            if(y.equals(year) && m.equals(month))
            {
                num++;
                price += order_list.getTotalPrice().doubleValue();
            }
        }
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("num", num);
        model.addAttribute("price", price);
        return "shop/statistics";
    }
}
