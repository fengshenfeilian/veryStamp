package com.managementSystem.controller;


import com.managementSystem.pojo.Shop;
import com.managementSystem.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        return "shop/modifyInfo";
    }

    @RequestMapping(value = "/modifyInfo", method = RequestMethod.POST)
    public String modifyInfo(@RequestParam(value = "shopId")String shopId,
                             @RequestParam(value = "password")String password,
                             @RequestParam(value = "confirmPassword") String confirmPassword,
                             @RequestParam(value = "address") String address,
                             Model model, HttpSession session, HttpServletRequest request)
    {
        Shop shop = (Shop) session.getAttribute("currentShop");
        return "shop/infoManager";
    }

}
