package com.danny.dao;

import com.danny.bean.RoleFunction;
import com.danny.bean.RoleFunctionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleFunctionMapper {
    long countByExample(RoleFunctionExample example);

    int deleteByExample(RoleFunctionExample example);

    int deleteByPrimaryKey(Integer rfid);

    int insert(RoleFunction record);

    int insertSelective(RoleFunction record);

    List<RoleFunction> selectByExample(RoleFunctionExample example);

    RoleFunction selectByPrimaryKey(Integer rfid);

    int updateByExampleSelective(@Param("record") RoleFunction record, @Param("example") RoleFunctionExample example);

    int updateByExample(@Param("record") RoleFunction record, @Param("example") RoleFunctionExample example);

    int updateByPrimaryKeySelective(RoleFunction record);

    int updateByPrimaryKey(RoleFunction record);
}