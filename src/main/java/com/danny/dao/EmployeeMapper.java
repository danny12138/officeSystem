package com.danny.dao;

import com.danny.bean.Employee;
import com.danny.bean.EmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer eid);

    /**
     * 新增员工信息(密码等于账号)
     * @param record
     * @return
     */
    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer eid);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    /**
     * 根据条件获取员工信息
     * @param employee
     * @return
     */
    List<Employee> findEmployeesByCondition(Employee employee);

    /**
     * 根据条件获取员工总数
     * @param employee
     * @return
     */
    int countEmployeesByCondition(Employee employee);

    /**
     * 根据eid获取对应员工信息
     * @param eid
     * @return
     */
    Employee findEmployeeRolesByEid(int eid);

    /**
     * 更新修改密码
     * @param eid
     * @param epassword
     * @return
     */
    int updatePassword(@Param("current_eid") int eid, @Param("newPassword") String epassword, @Param("salt") String salt);


}