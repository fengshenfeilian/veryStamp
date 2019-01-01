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

    public Shop getShopById(String userId)
    {
        Shop shop = shopMapper.selectByPrimaryKey(userId);
        return shop;
    }

    public List<Shop> getShopByName(String userName)
    {
        ShopExample shopExample = new ShopExample();
        ShopExample.Criteria criteria = shopExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        return shopMapper.selectByExample(shopExample);
    }

    public void insertShop(Shop newShop)
    {
        shopMapper.insert(newShop);
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

    public Consumer getConsumerById(String userId)
    {
        Consumer consumer = consumerMapper.selectByPrimaryKey(userId);
        return consumer;
    }

    public List<Consumer> getConsumerByName(String userName)
    {
        ConsumerExample consumerExample = new ConsumerExample();
        ConsumerExample.Criteria criteria = consumerExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        return consumerMapper.selectByExample(consumerExample);
    }

    public void insertConsumer(Consumer newConsumer)
    {
        if(newConsumer != null){
            consumerMapper.insert(newConsumer);
        }
    }

    @Autowired
    AdminMapper adminMapper;
    public Admin getAdminUser(String userId, String password)
    {
        Admin admin = adminMapper.selectByPrimaryKey(userId);
        if(admin != null){
            if(admin.getPassword().equals(password)){
                return admin;
            }
        }
        return null;
    }

    public Admin getAdminById(String userId)
    {
        Admin admin = adminMapper.selectByPrimaryKey(userId);
        return admin;
    }

    @Autowired
    Company_InfoMapper company_infoMapper;
    public Company_Info getCompanyInfoById(String companyId)
    {
        return company_infoMapper.selectByPrimaryKey(companyId);
    }

}
