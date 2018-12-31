package com.managementSystem.service;


import com.managementSystem.dao.*;
import com.managementSystem.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.List;

@Service
public class UserService {

    @Autowired
    ShopMapper shopMapper;
    public Shop getShop(String userId, String password)
    {
        //通过userId,
        Shop shop = shopMapper.selectByPrimaryKey(userId);
        if(shop == null){
            return null;
        }
        if(shop.getPassword().equals(password)) {
            return shop;
        }
        return null;
    }

    @Autowired
    ConsumerMapper consumerMapper;
    public Consumer getConsumer(String userId,String password)
    {
        Consumer consumer = consumerMapper.selectByPrimaryKey(userId);
        if(consumer == null){
            return null;
        }
        if(consumer.getPassword().equals(password)){
            return consumer;
        }
        return null;
    }


}
