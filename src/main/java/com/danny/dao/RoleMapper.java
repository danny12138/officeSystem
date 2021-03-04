package com.danny.dao;

import com.danny.bean.Employee;
import com.danny.bean.Role;
import com.danny.bean.Role;
import com.danny.bean.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAllRoles();

    /**
     * 根据条件获取角色信息
     * @param role
     * @return
     */
    List<Role> findRolesByCondition(Role role);

    /**
     * 根据条件获取角色总数
     * @param role
     * @return
     */
    int countRolesByCondition(Role role);

    /**
     * 根据rid获取对应角色信息
     * @param rid
     * @return
     */
    Role findRoleByRid(int rid);

    /**
     * 根据eid获取角色信息
     * @param eid
     * @return
     */
    List<Role> findRolesByEid (int eid);

}