package com.danny.service.impl;

import com.danny.bean.*;
import com.danny.dao.EfunctionMapper;
import com.danny.dao.EmployeeRoleMapper;
import com.danny.dao.RoleFunctionMapper;
import com.danny.dao.RoleMapper;
import com.danny.service.RoleService;
import com.danny.util.BaseResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    private static Logger logger = Logger.getLogger(RoleServiceImpl.class);
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private EmployeeRoleMapper employeeRoleMapper;
    @Autowired
    private RoleFunctionMapper roleFunctionMapper;
    @Autowired
    private EfunctionMapper efunctionMapper;

    /**
     * 根据条件筛选得到角色结果集
     * @param role
     * @return
     */
    @Override
    public List<Role> findRolesByCondition(Role role) {
        logger.info("角色条件搜索方法开始,入参: "+role);
        return roleMapper.findRolesByCondition(role);
    }

    /**
     * 根据条件筛选得到角色结果集的总数
     * @param role
     * @return
     */
    @Override
    public int countRolesByCondition(Role role) {
        return roleMapper.countRolesByCondition(role);
    }

    @Override
    public Role findRoleByRid(int rid) {
        return null;
    }

    /**
     * 根据rid修改角色信息
     * @param role
     * @return
     */
    @Override
    public BaseResult updateRoleByRid(Role role) {
        logger.info("角色修改方法开始,入参: "+role);
        BaseResult baseResult = new BaseResult();
        //新增角色参数不能为空
        if (role.getRcode()==null||role.getRname()==null){
            baseResult.setSuccess(false);
            baseResult.setMessage("角色信息不能为空,请重新输入");
            return baseResult;
        }
        //校验角色编码是否唯一
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andRcodeEqualTo(role.getRcode());
        criteria.andRidNotEqualTo(role.getRid());

        List<Role> roleList = roleMapper.selectByExample(roleExample);
        if (roleList!=null&&roleList.size()>0){
            baseResult.setSuccess(false);
            baseResult.setMessage("角色编码已存在,请重新输入");
            return baseResult;
        }
        int result = roleMapper.updateByPrimaryKey(role);
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
     * 新增角色
     * @param role
     * @return
     */
    @Override
    public BaseResult insertRole(Role role) {
        logger.info("角色新增方法开始,入参: "+role);
        BaseResult baseResult = new BaseResult();
        //新增角色参数不能为空
        if (role.getRcode()==null||role.getRname()==null){
            baseResult.setSuccess(false);
            baseResult.setMessage("新增信息不能为空,请重新输入");
            return baseResult;
        }
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andRcodeEqualTo(role.getRcode());

        List<Role> roleList = roleMapper.selectByExample(roleExample);
        System.out.println(roleList);
        if (roleList!=null&&roleList.size()>0){
            baseResult.setSuccess(false);
            baseResult.setMessage("角色编码已存在,请重新输入");
            return baseResult;
        }
        int result = roleMapper.insert(role);
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
     * 根据rid删除角色
     * @param rid
     * @return
     */
    @Override
    @Transactional
    public BaseResult deleteRoleByRid(int rid) {
        logger.info("角色删除方法开始,入参: "+rid);
        BaseResult baseResult = new BaseResult();
        if (rid==1){
            baseResult.setMessage("管理员很重要,不能被删除");
            baseResult.setSuccess(false);
            return baseResult;
        }
        try {
            //查询跟该角色相关的中间表信息并删除这些信息
            //EmployeeRole表
            EmployeeRoleExample employeeRoleExample = new EmployeeRoleExample();
            employeeRoleExample.createCriteria().andRidEqualTo(rid);
            employeeRoleMapper.deleteByExample(employeeRoleExample);

            //RoleFunction表
            RoleFunctionExample roleFunctionExample = new RoleFunctionExample();
            roleFunctionExample.createCriteria().andRidEqualTo(rid);
            roleFunctionMapper.deleteByExample(roleFunctionExample);

            roleMapper.deleteByPrimaryKey(rid);
            baseResult.setMessage("该角色以及相关的中间表信息删除成功");
            baseResult.setSuccess(true);
            } catch (Exception e){
            e.printStackTrace();
            //事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            baseResult.setMessage("删除失败");
            baseResult.setSuccess(false);
        }
        logger.info("删除结束，出参："+baseResult);
        return baseResult;
    }

    @Override
    @Transactional
    public BaseResult batchDelete(List<Integer> rids) {
        logger.info("批量删除开始，入参："+rids);
        BaseResult baseResult = new BaseResult();
        try {
            for (int rid : rids) {
                BaseResult result = deleteRoleByRid(rid);
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
    public List<Role> selectAllRoles() {
        return roleMapper.selectAllRoles();
    }

    /**
     * 获取当前角色所拥有功能权限
     * @param rid
     * @return
     */
    @Override
    public List<Efunction> getFunctionsByRid(int rid) {
        logger.info("获取当前角色所拥有功能权限方法开始,入参: "+rid);
        //先获取roleFunction中的fid
        RoleFunctionExample roleFunctionExample = new RoleFunctionExample();
        RoleFunctionExample.Criteria criteria = roleFunctionExample.createCriteria();
        criteria.andRidEqualTo(rid);
        List<RoleFunction> roleFunctionList = roleFunctionMapper.selectByExample(roleFunctionExample);
        //根据fid获取List<Efunction>
        List<Efunction> efunctionList = new ArrayList<>();
        for (RoleFunction rf : roleFunctionList){
            Efunction efunction = efunctionMapper.findEfunctionByFid(rf.getFid());
            efunctionList.add(efunction);
        }
        return efunctionList;
    }

    /**
     * 根据当前角色和选中的功能更新RoleFunction表
     * @param rid
     * @param fids
     * @return
     */
    @Override
    public BaseResult updateRoleFunction(int rid, List<Integer> fids) {
        logger.info("根据当前角色和选中的功能更新RoleFunction表方法开始,入参: rid "+rid+" fids "+fids);
        BaseResult baseResult = new BaseResult();
        int result = 0;
        RoleFunctionExample roleFunctionExample = new RoleFunctionExample();
        RoleFunctionExample.Criteria criteria = roleFunctionExample.createCriteria();
        //将之前已有的保留(保留rfid),不在的去掉,新的新增(新增rfid)
        criteria.andRidEqualTo(rid);
        //获取先前的旧数据
        List<RoleFunction> oldRoleFunctions = roleFunctionMapper.selectByExample(roleFunctionExample);
        //遍历旧数据,执行保留,删除,新增
        for (RoleFunction rf : oldRoleFunctions){
            //把重复部分保留
            if (fids.contains(rf.getFid())){
                fids.remove(rf.getFid());
            }
            else {
                result = roleFunctionMapper.deleteByPrimaryKey(rf.getRfid());
            }
        }
        //将列表中剩下的数据新增
        for (Integer fidLeft : fids){
            result = roleFunctionMapper.insert(new RoleFunction(rid,fidLeft));
        }
        if (result != 0){
            baseResult.setMessage("角色功能权限更新成功!");
            baseResult.setSuccess(true);
        } else {
            baseResult.setMessage("角色功能权限更新失败...");
            baseResult.setSuccess(false);
        }
        return baseResult;
    }

    @Override
    public List<Role> findRolesByEid(int eid) {
        return roleMapper.findRolesByEid(eid);
    }
}
