package com.danny.service;

import com.danny.bean.Employee;
import com.danny.bean.Role;
import com.danny.util.BaseResult;
import com.danny.util.EmployeeResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeService {
    /**
     * 登录校验
     * @param ejobno
     * @param epassword
     * @return
     */
    EmployeeResult loginCheck(String ejobno, String epassword);

    /**
     * 使用shiro做认证校验(登录校验)
     * @param ejobno
     * @param epassword
     * @return
     */
    EmployeeResult shiroLogin(String ejobno, String epassword);

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
     * 根据eid修改员工信息
     * @param employee
     * @return
     */
    BaseResult updateEmployeeByEid(Employee employee);

    /**
     * 新增员工(初始密码等于账号)
     * @param employee
     * @return
     */
    BaseResult insertEmployee(Employee employee);

    /**
     * 根据eid删除员工信息
     * @param eid
     * @return
     */
    BaseResult deleteEmployeeByEid(int eid, int currentEid);

    /**
     * 批量删除eids
     * @param eids
     * @return
     */
    BaseResult batchDelete(List<Integer> eids, int currentEid);

    /**
     * 更新修改密码
     * @param eid
     * @param epassword
     * @return
     */
    BaseResult updatePassword(int eid, String epassword);

    /**
     * 更新修改员工角色表
     * @param eid
     * @param rids
     * @return
     */
    BaseResult updateEmployeeRole(int eid, List<Integer> rids, String newPassword);

    /**
     * 更改密码时验证旧密码是否正确
     * @param eid
     * @param epassword
     * @return
     */
    BaseResult checkOldPassword(int eid, String epassword);


    Employee findEmployeeByEid(int eid);

}
