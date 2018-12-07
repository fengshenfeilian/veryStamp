package com.managementSystem.dao;

import com.managementSystem.pojo.Consumer;
import com.managementSystem.pojo.ConsumerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsumerMapper {
    long countByExample(ConsumerExample example);

    int deleteByExample(ConsumerExample example);

    int deleteByPrimaryKey(String consumerId);

    int insert(Consumer record);

    int insertSelective(Consumer record);

    List<Consumer> selectByExample(ConsumerExample example);

    Consumer selectByPrimaryKey(String consumerId);

    int updateByExampleSelective(@Param("record") Consumer record, @Param("example") ConsumerExample example);

    int updateByExample(@Param("record") Consumer record, @Param("example") ConsumerExample example);

    int updateByPrimaryKeySelective(Consumer record);

    int updateByPrimaryKey(Consumer record);
}