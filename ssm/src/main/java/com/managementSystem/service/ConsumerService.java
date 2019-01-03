package com.managementSystem.service;


import com.managementSystem.dao.*;
import com.managementSystem.pojo.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        String rootPath = "C:/VeryStamp/";
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

    public List<Resource> getShopResourceList()
    {
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        criteria.andResTypeEqualTo("shop");
        return resourceMapper.selectByExample(resourceExample);
    }

    public List<Shop> getShopListByResourceList(List<Resource> resourceList)
    {
        List<Shop> shopList = new ArrayList<>();
        for(Resource resource : resourceList)
        {
            Shop shop = shopMapper.selectByPrimaryKey(resource.getShopId());
            if(shop != null){
                shopList.add(shop);
            }
        }
        return shopList;
    }

    public void addResource(Resource resource) {
        resourceMapper.insert(resource);
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

    public Order_List convertOrder(Order_List order)
    {
        Resource resource = resourceMapper.selectByPrimaryKey(order.getResId());
        order.setResourceName(resource.getResName());
        if(order.getPrintFormat().equals("single")){
            order.setPrintFormat("单面");
        }
        else if(order.getPrintFormat().equals("double")){
            order.setPrintFormat("双面");
        }
        Shop shop = shopMapper.selectByPrimaryKey(order.getShopId());
        order.setShopId(shop.getUserName());
        return order;
    }

    public List<Order_List> getToPrintOrderList(String consumerId)
    {
        List<Order_List> list = new ArrayList<>();
        List<Order_List> allOrderList = getOrdersByConsumerId(consumerId);
        for(Order_List order : allOrderList)
        {
            if(order.getState().equals("等待打印")){
                order = convertOrder(order);
                list.add(order);
            }
        }
        return list;
    }

    public List<Order_List> getToReceiveOrderList(String consumerId)
    {
        List<Order_List> list = new ArrayList<>();
        List<Order_List> allOrderList = getOrdersByConsumerId(consumerId);
        for(Order_List order : allOrderList)
        {
            if(order.getState().equals("待取货")){
                order = convertOrder(order);
                list.add(order);
            }
        }
        return list;
    }

    public List<Order_List> getCompleteOrderList(String consumerId)
    {
        List<Order_List> list = new ArrayList<>();
        List<Order_List> allOrderList = getOrdersByConsumerId(consumerId);
        for(Order_List order : allOrderList)
        {
            if(order.getState().equals("已完成")){
                order = convertOrder(order);
                list.add(order);
            }
        }
        return list;
    }

    public Resource getResourceById(String resId)
    {
        return resourceMapper.selectByPrimaryKey(resId);
    }

    public Shop getShopByResId(String resId)
    {
        return  shopMapper.selectByPrimaryKey(resId);
    }

    public List<Resource> getResListByOrderList(List<Order_List> orderList)
    {
        List<Resource> resList = new ArrayList<>();
        for(Order_List order : orderList)
        {
            Resource res = resourceMapper.selectByPrimaryKey(order.getResId());
            resList.add(res);
        }
        return resList;
    }

    public Boolean updateConsumerCredit(Consumer consumer, Integer money)
    {
        Consumer_Credit credit = consumerCreditMapper.selectByPrimaryKey(consumer.getConsumerId());
        if(credit != null){
            Date date = new Date();

            Consumer_Credit newCredit = new Consumer_Credit();
            newCredit.setConsumerId(consumer.getConsumerId());
            newCredit.setLatestUpdateTime(date);
            newCredit.setCredit(credit.getCredit() + money);
            consumerCreditMapper.updateByPrimaryKey(newCredit);
            /*
            Consumer_CreditExample newCreditExample;
            Consumer_CreditExample.Criteria criteria =  newCredit.createCriteria();
            criteria.andConsumerIdEqualTo(consumer.getConsumerId());
            criteria.andLatestUpdateTimeEqualTo(date);
            criteria.andCreditEqualTo(credit.getCredit() + money);
            */
            return true;
        }
        return false;
    }

}
