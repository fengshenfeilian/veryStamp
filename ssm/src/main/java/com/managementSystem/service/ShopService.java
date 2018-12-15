package com.managementSystem.service;


import com.managementSystem.dao.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    @Autowired
    ShopMapper shopMapper;
}
