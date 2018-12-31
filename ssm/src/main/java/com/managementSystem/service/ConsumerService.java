package com.managementSystem.service;


import com.managementSystem.dao.*;
import com.managementSystem.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@Service
public class ConsumerService {

    @Autowired
    ConsumerMapper consumerMapper;
    @Autowired
    ShopMapper shopMapper;
    @Autowired
    Order_ListMapper orderListMapper;
    @Autowired
    Consumer_CreditMapper consumerCreditMapper;
    @Autowired
    ResourceMapper resourceMapper;

    public void changePassword(Consumer consumer, String password) {
        consumer.setPassword(password);
        consumerMapper.updateByPrimaryKey(consumer);
    }

    public List<Shop> getAll() {
        return shopMapper.findAll();
    }

    public List<Order_List> getOrdersByConsumerId(String consumerId) {
        Order_ListExample order_listExample = new Order_ListExample();
        Order_ListExample.Criteria criteria = order_listExample.createCriteria();
        criteria.andUserIdEqualTo(consumerId);
        return orderListMapper.selectByExample(order_listExample);
    }

    public Consumer_Credit getConsumerCredit(String consumerId) {
        Consumer_Credit consumerCredit = consumerCreditMapper.selectByPrimaryKey(consumerId);
        if (consumerCredit != null) {
            return consumerCredit;
        }
        System.out.println("No ConsumerCredit Object");
        return null;
    }

    public void saveFile(MultipartFile file) {
        Calendar date = Calendar.getInstance();
        String datePath = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH) + 1) + "/";
        String rootPath = "E:/pro/file/";
        String filename = file.getOriginalFilename();
        try {
            File destFile = new File(rootPath + datePath + filename);
            if (!destFile.getParentFile().exists()) {
                destFile.mkdirs();
            }
            file.transferTo(destFile);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }


    public String addResource(Resource resource) {
        resourceMapper.insert(resource);
        return resource.getResId();
    }

    public void addOrder(Order_List orderList) {
        orderListMapper.insert(orderList);
    }


    public String getResourceNameByResId(String resId) {

        return resourceMapper.selectByPrimaryKey(resId).getResName();
    }

    public String getShopNameByShopId(String ShopId)
    {
       return shopMapper.selectByPrimaryKey(ShopId).getUserName();
    }
}
