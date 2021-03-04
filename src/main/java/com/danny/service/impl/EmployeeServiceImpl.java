package com.danny.service.impl;

import com.danny.bean.Employee;
import com.danny.bean.EmployeeExample;
import com.danny.bean.EmployeeRole;
import com.danny.bean.EmployeeRoleExample;
import com.danny.dao.EmployeeMapper;
import com.danny.dao.EmployeeRoleMapper;
import com.danny.service.EmployeeService;
import com.danny.util.BaseResult;
import com.danny.util.EmployeeResult;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeRoleMapper employeeRoleMapper;

    /**
     * 登录校验
     * @param ejobno
     * @param epassword
     * @return
     */
    @Override
    public EmployeeResult loginCheck(String ejobno, String epassword) {
        logger.info("登录校验方法开始,入参: "+ejobno);
        EmployeeResult result = new EmployeeResult();
        try{
            EmployeeExample employeeExample = new EmployeeExample();
            EmployeeExample.Criteria criteria = employeeExample.createCriteria();
            criteria.andEjobnoEqualTo(ejobno);
            criteria.andEpasswordEqualTo(epassword);
            List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
            if (employeeList != null && employeeList.size() > 0){
                result.setLoginSuccess(true);
                result.setMessage("登录成功");
                result.setEmployee(employeeList.get(0));
            } else {
                result.setLoginSuccess(false);
                result.setMessage("用户名或者密码错误");
            }
            result.setSuccess(true);
        } catch (Exception e){
            logger.error(e.getMessage());
            result.setSuccess(false);
            result.setMessage("操作失败");
        }
        logger.info("登录校验方法结束,出参: "+result);
        return result;
    }

    @Override
    public EmployeeResult shiroLogin(String ejobno, String epassword) {
        EmployeeResult result = new EmployeeResult();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(ejobno,epassword);
        try {
            subject.login(token);
            result.setSuccess(true);
            result.setLoginSuccess(true);
            result.setMessage("登录成功");
            //获取shiro的session
            Session session = subject.getSession();
            Employee employee = (Employee) subject.getPrincipal();
            //将登录成功的用户存放到session中
            session.setAttribute("employee",employee);
        } catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setLoginSuccess(false);
            result.setMessage("登录失败");
        }

        return result;
    }

    /**
     * 根据条件筛选得到员工结果集
     * @param employee
     * @return
     */
    @Override
    public List<Employee> findEmployeesByCondition(Employee employee) {
        logger.info("条件查询方法开始,入参: "+employee);
        List<Employee> employeeList = employeeMapper.findEmployeesByCondition(employee);

        for (Employee ee : employeeList){
            //Date类型转换成字符串类型
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = simpleDateFormat.format(ee.getEhiredate());
            ee.setEhiredateStr(date);
        }
        return employeeList;
    }

    /**
     * 根据条件筛选得到员工结果集的总数
     * @param employee
     * @return
     */
    @Override
    public int countEmployeesByCondition(Employee employee) {
        int employeeNum = employeeMapper.countEmployeesByCondition(employee);
        return employeeNum;
    }


    /**
     * 根据eid修改员工信息
     * @param employee
     * @return
     */
    @Override
    public BaseResult updateEmployeeByEid(Employee employee){
        logger.info("用户更新方法开始,入参: "+employee);
        BaseResult baseResult = new BaseResult();
        if (employee.getEname()==null||employee.getEhiredateStr()==null||employee.getEsex()==null||employee.getEage()==null||employee.getEphoneno()==null||employee.getEjobno()==null){
            baseResult.setSuccess(false);
            baseResult.setMessage("员工信息不能为空,请重新输入");
            return baseResult;
        }
        //校验修改前的员工工号是否重复, 校验工号(登录账号)的唯一
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEjobnoEqualTo(employee.getEjobno());
        criteria.andEidNotEqualTo(employee.getEid());
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
        if (employeeList!=null&&employeeList.size()>0){
            baseResult.setSuccess(false);
            baseResult.setMessage("工号已存在,请重新输入");
            return baseResult;
        }
        //密码加密
        String salt=new SecureRandomNumberGenerator().nextBytes().toHex();
        String newPassword=new Md5Hash(employee.getEpassword(),salt,3).toString();
        employee.setEpassword(newPassword);
        employee.setEremark1(salt);
        //修改员工基本信息
        int result = employeeMapper.updateByPrimaryKey(employee);
        if (result == 0) {
            baseResult.setSuccess(false);
            baseResult.setMessage("修改失败,请稍后再试");
        } else {
            baseResult.setSuccess(true);
            baseResult.setMessage("修改成功");
        }
        return baseResult;
    }

    /**
     * 新增员工
     * @param employee
     * @return
     */
    @Override
    public BaseResult insertEmployee(Employee employee){
        logger.info("用户新增方法开始,入参: "+employee);
        BaseResult baseResult = new BaseResult();
        if (employee.getEname()==null||employee.getEhiredateStr()==null||employee.getEsex()==null||employee.getEage()==null||employee.getEphoneno()==null||employee.getEjobno()==null){
            baseResult.setSuccess(false);
            baseResult.setMessage("新增信息不能为空,请重新输入");
            return baseResult;
        }
        //校验修改前的员工工号是否重复, 校验工号(登录账号)的唯一
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEjobnoEqualTo(employee.getEjobno());
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
        if (employeeList!=null&&employeeList.size()>0){
            baseResult.setSuccess(false);
            baseResult.setMessage("工号已存在,请重新输入");
            return baseResult;
        }
        //(初始密码等于账号)
        //新增员工前对密码进行加密处理
        //生成加密盐(随机数)
        String salt=new SecureRandomNumberGenerator().nextBytes().toHex();
        String newPassword=new Md5Hash(employee.getEpassword(),salt,3).toString();
        employee.setEpassword(newPassword);
        employee.setEremark1(salt);
        int result = employeeMapper.insert(employee);
        if (result == 0) {
            baseResult.setSuccess(false);
            baseResult.setMessage("新增失败,请稍后再试");
        } else {
            baseResult.setSuccess(true);
            baseResult.setMessage("新增成功");
        }
        return baseResult;
    }

    /**
     * 根据eid删除员工信息
     * @param eid
     * @return
     */
    @Override
    @Transactional
    public BaseResult deleteEmployeeByEid(int eid, int current_eid){
        logger.info("用户删除方法开始,入参: "+eid);
        BaseResult baseResult = new BaseResult();
        if (eid == current_eid){
            baseResult.setSuccess(false);
            baseResult.setMessage("用户不能删除自己");
            return baseResult;
        }
        if (eid == 1){
            baseResult.setSuccess(false);
            baseResult.setMessage("这个用户不能删除");
            return baseResult;
        }
        try {
            EmployeeRoleExample employeeRoleExample = new EmployeeRoleExample();
            EmployeeRoleExample.Criteria criteria = employeeRoleExample.createCriteria();
            criteria.andEidEqualTo(eid);
            //删除关系表
            employeeRoleMapper.deleteByExample(employeeRoleExample);
            //删除用户
            employeeMapper.deleteByPrimaryKey(eid);
            baseResult.setMessage("删除成功");
            baseResult.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            baseResult.setMessage("删除失败");
            baseResult.setSuccess(false);
        }
        logger.info("用户删除方法结束,出参: "+baseResult);
        return baseResult;
    }

    @Override
    @Transactional
    public BaseResult batchDelete(List<Integer> eids, int current_eid) {
        logger.info("批量删除开始，入参："+eids);
        BaseResult baseResult = new BaseResult();
        try {
            for (int eid : eids) {
                BaseResult result = deleteEmployeeByEid(eid,current_eid);
                if (!result.isSuccess()){
                    throw new Exception();
                }
            }
            baseResult.setSuccess(true);
            baseResult.setMessage("批量删除成功");
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            baseResult.setSuccess(false);
            baseResult.setMessage("批量删除失败");
        }
        logger.info("批量删除结束，出参："+baseResult);
        return baseResult;
    }

    @Override
    public BaseResult updatePassword(int eid, String epassword) {
        logger.info("用户修改密码方法开始,入参: eid "+eid);
        BaseResult baseResult = new BaseResult();
        //密码加密
        String salt=new SecureRandomNumberGenerator().nextBytes().toHex();
        String newPassword=new Md5Hash(epassword,salt,3).toString();
        int result = employeeMapper.updatePassword(eid,newPassword,salt);
        if (result != 0){
            baseResult.setMessage("密码修改成功!");
            baseResult.setSuccess(true);
        } else {
            baseResult.setMessage("密码修改失败,请稍后尝试!");
            baseResult.setSuccess(false);
        }
        return baseResult;
    }

    @Override
    @Transactional
    public BaseResult updateEmployeeRole(int eid, List<Integer> rids, String newPassword) {
        logger.info("用户修改角色方法开始,入参: eid "+eid+";rids: "+rids);
        logger.info("用户新密码,入参: "+newPassword);
        BaseResult baseResult = new BaseResult();
        try {
            //删除以前的员工角色信息
            EmployeeRoleExample employeeRoleExample = new EmployeeRoleExample();
            EmployeeRoleExample.Criteria criteria1 = employeeRoleExample.createCriteria();
            criteria1.andEidEqualTo(eid);
            employeeRoleMapper.deleteByExample(employeeRoleExample);
            //新增新的员工信息
            for (int rid : rids) {
                employeeRoleMapper.insert(new EmployeeRole(eid, rid));
            }
            baseResult.setSuccess(true);
            baseResult.setMessage("员工角色信息更新成功!");
            //如果有新密码就更新密码
            if (!"".equals(newPassword)&&newPassword.length()>0) {
                updatePassword(eid, newPassword);
            }
        } catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            baseResult.setSuccess(false);
            baseResult.setMessage("员工角色信息更新失败,请稍后再试!");
        }
        return baseResult;
    }

    @Override
    public BaseResult checkOldPassword(int eid, String epassword) {
        BaseResult baseResult = new BaseResult();
        Employee employee = employeeMapper.selectByPrimaryKey(eid);
        String salt = employee.getEremark1();
        String pwd = employee.getEpassword();
        //密码加密
        String newPassword=new Md5Hash(epassword,salt,3).toString();
        if (newPassword.equals(pwd)){
            baseResult.setSuccess(true);
            baseResult.setMessage("密码正确");
        } else {
            baseResult.setSuccess(false);
            baseResult.setMessage("原始密码错误,请重新输入!");
        }
        return baseResult;
    }

    @Override
    public Employee findEmployeeByEid(int eid) {
        return employeeMapper.selectByPrimaryKey(eid);
    }


}
