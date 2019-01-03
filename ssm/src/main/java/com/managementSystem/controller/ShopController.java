package com.managementSystem.controller;


import com.managementSystem.pojo.Order_List;
import com.managementSystem.pojo.Resource;
import com.managementSystem.pojo.Shop;
import com.managementSystem.pojo.Shop_Price;
import com.managementSystem.service.ShopService;
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
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;


    @RequestMapping(value = "/showInfo")
    public String showInfo(Model model, HttpSession session, HttpServletRequest request)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
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
                             Model model, HttpSession session, HttpServletRequest request)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        if(!(shop.getPassword().equals(oldPassword)))
        {
            model.addAttribute("message", "原密码错误");
            return "shop/modifyInfo";
        }
        else if(!password.equals(confirmPassword))
        {
            model.addAttribute("message", "前后密码不一致");
            return "shop/modifyInfo";
        }
        if(password != null)
        {
            shop.setPassword(password);
        }
        if(phone != null) shop.setPhone(phone);
        if(address != null) shop.setAddress(address);
        if(businessStartTime != null) shop.setBusinessStartTime(businessStartTime);
        if(businessEndTime != null) shop.setBusinessEndTime(businessEndTime);
        shopService.updateShop(shop);
        model.addAttribute("shop", shop);
        return "shop/infoManager";
    }

    public Order_List addPrice(Order_List order_list, String shopId)
    {
        Resource resource = shopService.getOrderedResource(order_list.getOrderId());
        order_list.setResourceName(resource.getResName());
        order_list.setTotalPageCount(resource.getPageCount()*order_list.getPrintCount());
        if(resource.getResType().equals("shop"))
        {
            order_list.setTotalPrice(resource.getTotalPrice().doubleValue() * order_list.getPrintCount());
        }
        else
        {
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
        }
        return order_list;
    }

    @RequestMapping(value = "/showToPrintOrder")
    public String showToReceiveOrder(Model model, HttpSession session)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        System.out.println(shop.getUserName());
        List<Order_List> order_lists = shopService.getOrdersByState(shop.getShopId(), "toPrint");
//        if(order_lists.isEmpty())
//        {
//            model.addAttribute("message", "当前没有需打印的订单");
//            model.addAttribute("shop", shop);
//            return "shop/toReceiveOrder";
//        }
        for(Order_List order_list : order_lists)
        {
            order_list = addPrice(order_list, shop.getShopId());
        }
        model.addAttribute("orders",order_lists);
        model.addAttribute("shop", shop);
        return "shop/toReceiveOrder";
    }

    @RequestMapping(value = "/showToReceiveOrder")
    public String showUncompletedOrder(Model model, HttpSession session)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        List<Order_List> order_lists = shopService.getOrdersByState(shop.getShopId(), "ToReceive");
//        if(order_lists.isEmpty())
//        {
//            model.addAttribute("message", "当前没有需领取的订单");
//            model.addAttribute("shop", shop);
//            return "shop/uncompletedOrder";
//        }
//        for(Order_List order_list : order_lists)
//        {
//            order_list = addPrice(order_list, shop.getShopId());
//        }
        model.addAttribute("orders",order_lists);
        model.addAttribute("shop", shop);
        return "shop/uncompletedOrder";
    }

    @RequestMapping(value = "/showCompletedOrder")
    public String showCompletedOrder(Model model, HttpSession session)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        List<Order_List> order_lists = shopService.getOrdersByState(shop.getShopId(), "completed");
//        if(order_lists.isEmpty())
//        {
//            model.addAttribute("message", "当前没有已完成的订单");
//            model.addAttribute("shop", shop);
//            return "shop/completedOrder";
//        }
//        for(Order_List order_list : order_lists)
//        {
//            order_list = addPrice(order_list, shop.getShopId());
//        }
        model.addAttribute("orders",order_lists);
        model.addAttribute("shop", shop);
        return "shop/completedOrder";
    }

    @RequestMapping(value = "/confirmReceive")
    public String confirmReceive(@RequestParam(value="orderId") String orderId, Model model, HttpSession session)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        shopService.updateOrderState(orderId, "toReceive");
        List<Order_List> order_lists = shopService.getOrdersByState(shop.getShopId(), "toPrint");
//        if(order_lists.isEmpty())
//        {
//            model.addAttribute("message", "当前没有需打印的订单");
//            model.addAttribute("shop", shop);
//            return "shop/toReceiveOrder";
//        }
//        for(Order_List order_list : order_lists)
//        {
//            order_list = addPrice(order_list, shop.getShopId());
//        }
        model.addAttribute("orders",order_lists);
        model.addAttribute("shop", shop);
        return "shop/toReceiveOrder";
    }

    @RequestMapping(value = "/confirmComplete")
    public String confirmComplete(@RequestParam(value="orderId") String orderId, Model model, HttpSession session)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        shopService.updateOrderState(orderId, "completed");
        List<Order_List> order_lists = shopService.getOrdersByState(shop.getShopId(), "toReceive");
//        if(order_lists.isEmpty())
//        {
//            model.addAttribute("message", "当前没有需领取的订单");
//            model.addAttribute("shop", shop);
//            return "shop/uncompletedOrder";
//        }
//        for(Order_List order_list : order_lists)
//        {
//            order_list = addPrice(order_list, shop.getShopId());
//        }
        model.addAttribute("orders",order_lists);
        model.addAttribute("shop", shop);
        return "shop/uncompletedOrder";
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
                shopService.saveResource(name, file);
                Resource resource = new Resource();
                resource.setResName(resName);
                resource.setShopId(shop.getShopId());
                resource.setResId(resName+shop.getShopId());
                resource.setDescription(description);
                resource.setPageCount(Integer.parseInt(pageCount));
                resource.setTotalPrice(new BigDecimal(Double.parseDouble(price)));
                resource.setResType("shop");
                model.addAttribute("message", "上传成功");
            }
        }
        List<Resource> resources = shopService.getResources(shop.getShopId(), "shop");
        model.addAttribute("resources", resources);
        model.addAttribute("shop", shop);
        return "shop/resourceManager";
    }
}
