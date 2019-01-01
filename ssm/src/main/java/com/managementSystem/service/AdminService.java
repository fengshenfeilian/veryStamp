package com.managementSystem.service;

import com.managementSystem.dao.*;
import com.managementSystem.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    ConsumerMapper consumerMapper;
    @Autowired
    ShopMapper shopMapper;
    @Autowired
    Order_ListMapper orderListMapper;
    @Autowired
    Consumer_CreditMapper consumerCreditMapper;
    @Autowired
    Shop_CreditMapper shop_creditMapper;
    @Autowired
    ResourceMapper resourceMapper;



    public List<Consumer> getConsumerList()
    {
        ConsumerExample consumerExample = new ConsumerExample();
        ConsumerExample.Criteria criteria = consumerExample.createCriteria();
        criteria.andConsumerIdIsNotNull();
        return consumerMapper.selectByExample(consumerExample);
    }

    public List<Consumer_Credit> getCreditByConsumerList(List<Consumer> consumerList)
    {
        List<Consumer_Credit> list = new ArrayList<>();
        for(Consumer consumer : consumerList)
        {
            Consumer_Credit consumer_credit = consumerCreditMapper.selectByPrimaryKey(consumer.getConsumerId());
            if(consumer_credit != null){
                list.add(consumer_credit);
            }
        }
        return list;
    }

    public List<Shop> getShopList()
    {
        ShopExample shopExample = new ShopExample();
        ShopExample.Criteria criteria = shopExample.createCriteria();
        criteria.andShopIdIsNotNull();
        return shopMapper.selectByExample(shopExample);
    }

    public List<Shop_Credit> getCreditByShopList(List<Shop> shopList)
    {
        List<Shop_Credit> list = new ArrayList<>();
        for(Shop shop : shopList)
        {
            Shop_Credit shop_credit = shop_creditMapper.selectByPrimaryKey(shop.getShopId());
            if(shop_credit != null){
                list.add(shop_credit);
            }
        }
        return list;
    }

}
