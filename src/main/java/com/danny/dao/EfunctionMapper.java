package com.danny.dao;

import com.danny.bean.Efunction;
import com.danny.bean.EfunctionExample;
import java.util.List;

import com.danny.bean.Efunction;
import org.apache.ibatis.annotations.Param;

public interface EfunctionMapper {
    long countByExample(EfunctionExample example);

    int deleteByExample(EfunctionExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Efunction record);

    int insertSelective(Efunction record);

    List<Efunction> selectByExample(EfunctionExample example);

    Efunction selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Efunction record, @Param("example") EfunctionExample example);

    int updateByExample(@Param("record") Efunction record, @Param("example") EfunctionExample example);

    int updateByPrimaryKeySelective(Efunction record);

    int updateByPrimaryKey(Efunction record);

    List<Efunction> selectAllEfunctions();

    /**
     * 根据条件获取角色信息
     * @param function
     * @return
     */
    List<Efunction> findEfunctionsByCondition(Efunction function);

    /**
     * 根据条件获取角色总数
     * @param function
     * @return
     */
    int countEfunctionsByCondition(Efunction function);

    /**
     * 根据rid获取对应角色信息
     * @param fid
     * @return
     */
    Efunction findEfunctionByFid(int fid);

    /**
     * 根据用户id获取功能信息
     * @param eid
     * @return
     */
    List<Efunction> findFunctionsByEid(int eid);

    /**
     * 根据fid设置该节点是否为最终节点
     * @param fid
     * @return
     */
    int updateStateByFid(@Param("fid")int fid,@Param("state") String state);
}