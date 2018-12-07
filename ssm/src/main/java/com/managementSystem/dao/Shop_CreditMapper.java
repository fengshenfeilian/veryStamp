package com.managementSystem.dao;

import com.managementSystem.pojo.Shop_Credit;
import com.managementSystem.pojo.Shop_CreditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Shop_CreditMapper {
    long countByExample(Shop_CreditExample example);

    int deleteByExample(Shop_CreditExample example);

    int deleteByPrimaryKey(String shopId);

    int insert(Shop_Credit record);

    int insertSelective(Shop_Credit record);

    List<Shop_Credit> selectByExample(Shop_CreditExample example);

    Shop_Credit selectByPrimaryKey(String shopId);

    int updateByExampleSelective(@Param("record") Shop_Credit record, @Param("example") Shop_CreditExample example);

    int updateByExample(@Param("record") Shop_Credit record, @Param("example") Shop_CreditExample example);

    int updateByPrimaryKeySelective(Shop_Credit record);

    int updateByPrimaryKey(Shop_Credit record);
}