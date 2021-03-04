package com.danny.service;

import com.alibaba.fastjson.JSONArray;
import com.danny.bean.Efunction;
import com.danny.bean.Efunction;
import com.danny.util.BaseResult;

import java.util.List;

public interface FunctionService {
    /**
     * 根据用户id获取功能信息
     * @param eid
     * @return
     */
    List<Efunction> findFunctionsByEid(int eid);

    /**
     * 将功能列表转换为前端识别的菜单格式json字符串
     * @param efunctions
     * @return
     */
    JSONArray convert(List<Efunction> efunctions);

    /**
     * 使用递归动态生成权限功能树
     * @param efunctions
     * @param parentId
     * @return
     */
    JSONArray convert2(List<Efunction> efunctions,int parentId);

    /**
     * 根据条件获取功能信息
     * @param function
     * @return
     */
    List<Efunction> findEfunctionsByCondition(Efunction function);

    /**
     * 根据条件获取功能总数
     * @param function
     * @return
     */
    int countEfunctionsByCondition(Efunction function);

    /**
     * 根据efun获取所有上级标签
     * @param fid
     * @return
     */
    List<Integer> findAllParentIdsByFid(int fid);

    /**
     * 根据fid修改功能信息
     * @param function
     * @return
     */
    BaseResult updateEfunctionByFid(Efunction function);

    /**
     * 新增功能
     * @param function
     * @return
     */
    BaseResult insertEfunction(Efunction function);

    /**
     * 根据fid删除功能信息
     * @param fid
     * @return
     */
    BaseResult deleteEfunctionByFid(int fid);

    /**
     * 批量删除功能
     * @param fids
     * @return
     */
    BaseResult batchDelete(List<Integer> fids);

    /**
     * 根据不同的功能等级查询显示可选择的功能父类
     * @return
     */
    List<Efunction> selectEfunctionsByFlevel(int flevel);

    /**
     * 获取所有系统功能
     * @return
     */
    List<Efunction> findAllFunctions();

    /**
     * 根据父fid查询该功能有哪些子功能
     * @param fid
     * @return
     */
    List<Integer> findChildrenIdByFid(int fid);

    
}
