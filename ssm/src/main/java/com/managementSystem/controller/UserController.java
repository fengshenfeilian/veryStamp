package com.managementSystem.controller;

import com.managementSystem.pojo.*;
import com.managementSystem.service.ShopService;
import com.managementSystem.service.UserService;
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
@RequestMapping("/user")

public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String modifyInfo(@RequestParam(value = "userId")String userId,
                             @RequestParam(value = "password")String password,
                             Model model, HttpSession session, HttpServletRequest request)
    {
        //System.out.println("userId = " + userId);
        //商户登陆校验
        Shop shop = userService.getShop(userId,password);
        if( shop != null) {
            //把user信息存储到session中
            request.getSession().setAttribute("currentShop", shop);
            //跳转至infoManager.jsp
            return "redirect:/shop/showInfo";
        }
        //普通用户登陆校验
        else{
            Consumer consumer = userService.getConsumer(userId,password);
            if(consumer != null ){
                System.out.println("consumer success");
                request.getSession().setAttribute("currentConsumer",consumer);
                return "redirect:/consumer/showInfo";
            }
        }
        return "redirect:/login.jsp";
    }

}
