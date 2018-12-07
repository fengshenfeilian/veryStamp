package com.managementSystem.dao;

import com.managementSystem.pojo.Order_List;
import com.managementSystem.pojo.Order_ListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Order_ListMapper {
    long countByExample(Order_ListExample example);

    int deleteByExample(Order_ListExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Order_List record);

    int insertSelective(Order_List record);

    List<Order_List> selectByExample(Order_ListExample example);

    Order_List selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Order_List record, @Param("example") Order_ListExample example);

    int updateByExample(@Param("record") Order_List record, @Param("example") Order_ListExample example);

    int updateByPrimaryKeySelective(Order_List record);

    int updateByPrimaryKey(Order_List record);
}