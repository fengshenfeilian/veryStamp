package com.managementSystem.controller;

import com.managementSystem.pojo.Consumer;
import com.managementSystem.pojo.Consumer_Credit;
import com.managementSystem.pojo.Shop;
import com.managementSystem.pojo.Shop_Credit;
import com.managementSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;


    @RequestMapping(value = "/home")
    public String goHome()
    {
        return "admin/home";
    }


    @RequestMapping(value = "/consumerManage")
    public String goConsumerManage(Model model)
    {
        List<Consumer> consumerList = adminService.getConsumerList();
        if ( (consumerList!=null) && (!consumerList.isEmpty())){
            List<Consumer_Credit> creditList = adminService.getCreditByConsumerList(consumerList);
            model.addAttribute("creditList",creditList);
        }
        model.addAttribute("consumerList",consumerList);
        return "admin/consumerManage";
    }

    @RequestMapping(value = "/shopManage")
    public String goShopManage(Model model)
    {
        List<Shop> shopList = adminService.getShopList();
        if( (shopList != null) && (!shopList.isEmpty())){
            List<Shop_Credit> creditList = adminService.getCreditByShopList(shopList);
            model.addAttribute("creditList",creditList);
        }
        model.addAttribute("shopList",shopList);
        return "admin/shopManage";
    }
}













