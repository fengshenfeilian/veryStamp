package com.managementSystem.dao;

import com.managementSystem.pojo.Company_Info;
import com.managementSystem.pojo.Company_InfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Company_InfoMapper {
    long countByExample(Company_InfoExample example);

    int deleteByExample(Company_InfoExample example);

    int deleteByPrimaryKey(String companyId);

    int insert(Company_Info record);

    int insertSelective(Company_Info record);

    List<Company_Info> selectByExample(Company_InfoExample example);

    Company_Info selectByPrimaryKey(String companyId);

    int updateByExampleSelective(@Param("record") Company_Info record, @Param("example") Company_InfoExample example);

    int updateByExample(@Param("record") Company_Info record, @Param("example") Company_InfoExample example);

    int updateByPrimaryKeySelective(Company_Info record);

    int updateByPrimaryKey(Company_Info record);
}