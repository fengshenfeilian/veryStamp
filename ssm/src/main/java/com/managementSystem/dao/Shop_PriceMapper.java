package com.managementSystem.dao;

import com.managementSystem.pojo.Shop_Price;
import com.managementSystem.pojo.Shop_PriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Shop_PriceMapper {
    long countByExample(Shop_PriceExample example);

    int deleteByExample(Shop_PriceExample example);

    int deleteByPrimaryKey(String shopId);

    int insert(Shop_Price record);

    int insertSelective(Shop_Price record);

    List<Shop_Price> selectByExample(Shop_PriceExample example);

    Shop_Price selectByPrimaryKey(String shopId);

    int updateByExampleSelective(@Param("record") Shop_Price record, @Param("example") Shop_PriceExample example);

    int updateByExample(@Param("record") Shop_Price record, @Param("example") Shop_PriceExample example);

    int updateByPrimaryKeySelective(Shop_Price record);

    int updateByPrimaryKey(Shop_Price record);
}