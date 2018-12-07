package com.managementSystem.dao;

import com.managementSystem.pojo.Consumer_Credit;
import com.managementSystem.pojo.Consumer_CreditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Consumer_CreditMapper {
    long countByExample(Consumer_CreditExample example);

    int deleteByExample(Consumer_CreditExample example);

    int deleteByPrimaryKey(String consumerId);

    int insert(Consumer_Credit record);

    int insertSelective(Consumer_Credit record);

    List<Consumer_Credit> selectByExample(Consumer_CreditExample example);

    Consumer_Credit selectByPrimaryKey(String consumerId);

    int updateByExampleSelective(@Param("record") Consumer_Credit record, @Param("example") Consumer_CreditExample example);

    int updateByExample(@Param("record") Consumer_Credit record, @Param("example") Consumer_CreditExample example);

    int updateByPrimaryKeySelective(Consumer_Credit record);

    int updateByPrimaryKey(Consumer_Credit record);
}