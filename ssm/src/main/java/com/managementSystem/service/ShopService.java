package com.managementSystem.service;


import com.managementSystem.dao.Order_ListMapper;
import com.managementSystem.dao.ResourceMapper;
import com.managementSystem.dao.ShopMapper;
import com.managementSystem.dao.Shop_PriceMapper;
import com.managementSystem.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ShopService {

    @Autowired
    ShopMapper shopMapper;
    @Autowired
    Order_ListMapper order_listMapper;
    @Autowired
    ResourceMapper resourceMapper;
    @Autowired
    Shop_PriceMapper shop_priceMapper;

    public void updateShop(Shop shop) {
        shopMapper.updateByPrimaryKey(shop);
    }

    public List<Order_List> getOrdersByState(String shopId, String state) {
        Order_ListExample order_listExample = new Order_ListExample();
        Order_ListExample.Criteria criteria = order_listExample.createCriteria();
        criteria.andStateEqualTo(state);
        criteria.andShopIdEqualTo(shopId);
        return order_listMapper.selectByExample(order_listExample);
    }

    public List<Resource> getResources(String shopId, String type) {
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        criteria.andShopIdEqualTo(shopId);
        criteria.andResTypeEqualTo(type);
        return resourceMapper.selectByExample(resourceExample);
    }

    public Resource getOrderedResource(String resId) {
        return resourceMapper.selectByPrimaryKey(resId);
    }

    public Shop_Price getShopPrice(String shopId) {
        Shop_Price shop_price = shop_priceMapper.selectByPrimaryKey(shopId);
        return shop_price;
    }

    public void updateOrderState(String orderId, String state) {
        Order_List order_list = order_listMapper.selectByPrimaryKey(orderId);
        order_list.setState(state);
        Date nowDate = new Date();
        order_list.setReadyTime(nowDate);
        order_listMapper.updateByPrimaryKey(order_list);
    }

    public void deleteResource(String resourceId) {
        resourceMapper.deleteByPrimaryKey(resourceId);
    }
    /*
        public void saveResource(String name, MultipartFile file) {
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
    */
    public void updateOrder(Order_List order_list) {
        order_listMapper.updateByPrimaryKey(order_list);
    }

    public Order_List getOrderById(String orderId) {
        return order_listMapper.selectByPrimaryKey(orderId);
    }

    public void updateShopPrice(Shop_Price shop_price) {
        shop_priceMapper.updateByPrimaryKey(shop_price);
    }

    public void insertResource(Resource resource) {
        resourceMapper.insert(resource);
    }
}
