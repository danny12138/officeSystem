package com.danny.service;

import com.danny.bean.Efunction;
import com.danny.bean.Role;
import com.danny.util.BaseResult;

import java.util.List;

public interface RoleService {
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
     * 根据rid修改角色信息
     * @param role
     * @return
     */
    BaseResult updateRoleByRid(Role role);

    /**
     * 新增角色
     * @param role
     * @return
     */
    BaseResult insertRole(Role role);

    /**
     * 根据rid删除角色信息
     * @param rid
     * @return
     */
    BaseResult deleteRoleByRid(int rid);

    /**
     * 批量删除rids
     * @param rids
     * @return
     */
    BaseResult batchDelete(List<Integer> rids);

    /**
     * 查询所有角色
     * @return
     */
    List<Role> selectAllRoles();

    /**
     * 获取当前角色所拥有功能权限
     * @param rid
     * @return
     */
    List<Efunction> getFunctionsByRid(int rid);

    /**
     * 根据当前角色和选中的功能更新RoleFunction表
     * @param rid
     * @param fids
     * @return
     */
    BaseResult updateRoleFunction(int rid, List<Integer> fids);
    /**
     * 根据eid获取角色信息
     * @param eid
     * @return
     */
    List<Role> findRolesByEid (int eid);
}
