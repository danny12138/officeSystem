package com.danny.realm;

import com.danny.bean.Efunction;
import com.danny.bean.Employee;
import com.danny.bean.EmployeeExample;
import com.danny.bean.Role;
import com.danny.dao.EfunctionMapper;
import com.danny.dao.EmployeeMapper;
import com.danny.dao.RoleMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeRealm extends AuthorizingRealm {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private EfunctionMapper efunctionMapper;
    /**
     * 获取数据库授权信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前登录用户信息
        Employee employee = (Employee) principalCollection.getPrimaryPrincipal();
        //获取当前用户的角色信息
        List<Role> roleList = roleMapper.findRolesByEid(employee.getEid());
        //将用户角色信息返回给shiro
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role : roleList) {
            simpleAuthorizationInfo.addRole(role.getRcode());
        }
        //获取当前用户的功能信息
        List<Efunction> efunctions = efunctionMapper.findFunctionsByEid(employee.getEid());
        for (Efunction efunction:efunctions){
            simpleAuthorizationInfo.addStringPermission(efunction.getFcode());
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 获取数据库认证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取数据库要校验的用户信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //获取页面传入的用户名
        String ejobno = token.getUsername();
        //根据用户名获取用户信息
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEjobnoEqualTo(ejobno);
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
        if (employeeList!=null&&employeeList.size()>0){
            Employee employee = employeeList.get(0);
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(employee,employee.getEpassword(),token.getUsername());
            //设置加密盐
//            if (employee.getEremark1()!=null&&!"".equals(employee.getEremark1()))
            simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(employee.getEremark1()));
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
