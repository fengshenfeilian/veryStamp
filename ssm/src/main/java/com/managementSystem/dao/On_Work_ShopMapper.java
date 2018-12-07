package com.managementSystem.dao;

import com.managementSystem.pojo.On_Work_Shop;
import com.managementSystem.pojo.On_Work_ShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface On_Work_ShopMapper {
    long countByExample(On_Work_ShopExample example);

    int deleteByExample(On_Work_ShopExample example);

    int deleteByPrimaryKey(String shopId);

    int insert(On_Work_Shop record);

    int insertSelective(On_Work_Shop record);

    List<On_Work_Shop> selectByExample(On_Work_ShopExample example);

    On_Work_Shop selectByPrimaryKey(String shopId);

    int updateByExampleSelective(@Param("record") On_Work_Shop record, @Param("example") On_Work_ShopExample example);

    int updateByExample(@Param("record") On_Work_Shop record, @Param("example") On_Work_ShopExample example);

    int updateByPrimaryKeySelective(On_Work_Shop record);

    int updateByPrimaryKey(On_Work_Shop record);
}