package com.danny.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.danny.bean.Efunction;
import com.danny.bean.EfunctionExample;
import com.danny.bean.RoleFunction;
import com.danny.bean.RoleFunctionExample;
import com.danny.dao.EfunctionMapper;
import com.danny.dao.RoleFunctionMapper;
import com.danny.service.FunctionService;
import com.danny.util.BaseResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

@Service
public class FunctionServiceImpl implements FunctionService {
    private static Logger logger = Logger.getLogger(RoleServiceImpl.class);

    @Autowired
    private EfunctionMapper efunctionMapper;

    @Autowired
    private RoleFunctionMapper roleFunctionMapper;

    @Override
    public List<Efunction> findFunctionsByEid(int eid) {
        List<Efunction> efunctions = efunctionMapper.findFunctionsByEid(eid);
        return efunctions;
    }

    /**
     * text是菜单显示的文本内容
     * icon 是菜单图片
     * right_text 是菜单右侧显示的提示文本，最大长度为3
     * active ,值为active；有该值，则默认选中该项，高亮
     * open，菜单是否展开
     */
    @Override
    public JSONArray convert(List<Efunction> efunctions) {
        JSONArray jsonArray = new JSONArray();
        //获取当前用户所有一级功能
        for (Efunction efunction : efunctions){
            if ("1".equals(efunction.getFlevel()) && efunction.getFparentid() == 0){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("fid",efunction.getFid());
                jsonObject.put("text",efunction.getFname());
                jsonObject.put("icon","nav-icon fas "+efunction.getFremark1());
                jsonObject.put("open","menu-open");
                //获取一级功能的子功能
                JSONArray children = new JSONArray();
                for (Efunction efunction1 : efunctions){
                    if ("2".equals(efunction1.getFlevel()) && efunction1.getFparentid().equals(efunction.getFid())){
                        JSONObject jsonObject1 = new JSONObject();
                        jsonObject1.put("fid",efunction1.getFid());
                        jsonObject1.put("text",efunction1.getFname());
                        jsonObject1.put("url",efunction1.getFurl());
                        jsonObject1.put("icon","nav-icon fas "+efunction1.getFremark1());
                        children.add(jsonObject1);
                        JSONArray children2 = new JSONArray();
                        for (Efunction efunction2 : efunctions){
                            if ("3".equals(efunction2.getFlevel()) && efunction2.getFparentid().equals(efunction1.getFid())){
                                JSONObject jsonObject2 = new JSONObject();
                                jsonObject2.put("fid",efunction2.getFid());
                                jsonObject2.put("text",efunction2.getFname());
                                jsonObject2.put("url",efunction2.getFurl());
                                jsonObject2.put("icon","nav-icon fas "+efunction2.getFremark1());
                                children2.add(jsonObject2);
                            }
                        }
                        if (!children2.isEmpty()){
                            jsonObject1.put("open","menu-open");
                            jsonObject1.put("children",children2);
                        }
                    }
                }
                jsonObject.put("children",children);
                jsonArray.add(jsonObject);
            }
        }
        return jsonArray;
    }

    @Override
    public JSONArray convert2(List<Efunction> efunctions, int parentId) {
        JSONArray jsonArray = new JSONArray();
        for (Efunction efunction : efunctions) {
            if (efunction.getFparentid() == parentId) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("fid", efunction.getFid());
                jsonObject.put("text", efunction.getFname());
                jsonObject.put("icon", "nav-icon fas " + efunction.getFremark1());
                //判断该节点是否是最终叶节点
                if ("NO".equals(efunction.getFremark2())) {
                    JSONArray children = convert2(efunctions, efunction.getFid());
                    jsonObject.put("open", "menu-close");
                    jsonObject.put("children", children);
                } else {
                    jsonObject.put("open", "menu-open");
                    jsonObject.put("url", efunction.getFurl());
                }
                jsonArray.add(jsonObject);
            }
        }
        return jsonArray;
    }

    @Override
    public List<Efunction> findEfunctionsByCondition(Efunction function) {
        logger.info("功能条件搜索方法开始,入参: "+function);
        return efunctionMapper.findEfunctionsByCondition(function);
    }

    @Override
    public int countEfunctionsByCondition(Efunction function) {
        return efunctionMapper.countEfunctionsByCondition(function);
    }

    @Override
    public BaseResult updateEfunctionByFid(Efunction function) {
        logger.info("功能修改方法开始,入参: "+function);
        BaseResult baseResult = new BaseResult();
        //新增功能不能为空
        if (function.getFcode()==null||function.getFname()==null||function.getFurl()==null||function.getFlevel()==null||"-1".equals(function.getFlevel())){
            baseResult.setSuccess(false);
            baseResult.setMessage("功能信息不能为空,请重新输入");
            return baseResult;
        }
        //校验功能编码是否唯一
        EfunctionExample efunctionExample = new EfunctionExample();
        EfunctionExample.Criteria criteria = efunctionExample.createCriteria();
        criteria.andFcodeEqualTo(function.getFcode());
        criteria.andFidNotEqualTo(function.getFid());

        List<Efunction> efunctionList = efunctionMapper.selectByExample(efunctionExample);
        if (efunctionList!=null&&efunctionList.size()>0){
            baseResult.setSuccess(false);
            baseResult.setMessage("功能编码已存在,请重新输入");
            return baseResult;
        }
        //更新前获取旧父节点的fid
        int oldParentId = efunctionMapper.selectByPrimaryKey(function.getFid()).getFparentid();

        if (function.getFparentid()==null){
            function.setFparentid(0);
        } else {
            //更新该父节点的状态
            efunctionMapper.updateStateByFid(function.getFparentid(),"NO");
        }
        int result = efunctionMapper.updateByPrimaryKey(function);
        if (result == 0) {
            baseResult.setSuccess(false);
            baseResult.setMessage("修改失败,请稍后再试");
        } else {
            baseResult.setSuccess(true);
            baseResult.setMessage("修改成功");
            //判断是否需要更新旧父节点的状态
            EfunctionExample efunctionExample1 = new EfunctionExample();
            EfunctionExample.Criteria criteria1 = efunctionExample1.createCriteria();
            criteria1.andFparentidEqualTo(oldParentId);
            List<Efunction> efunctionList1 = efunctionMapper.selectByExample(efunctionExample1);
            //查询更新后旧父节点是否还有叶节点,没有就更新状态
            if (efunctionList1==null||efunctionList1.size()==0){
                efunctionMapper.updateStateByFid(oldParentId,"YES");
            }

        }
        return baseResult;
    }

    @Override
    public BaseResult insertEfunction(Efunction function) {
        logger.info("功能新增方法开始,入参: "+function);
        BaseResult baseResult = new BaseResult();
        //新增功能不能为空
        if (function.getFcode()==null||function.getFname()==null||function.getFurl()==null||"-1".equals(function.getFlevel())){
            baseResult.setSuccess(false);
            baseResult.setMessage("功能信息不能为空,请重新输入");
            return baseResult;
        }
        //校验功能编码是否唯一
        EfunctionExample efunctionExample = new EfunctionExample();
        EfunctionExample.Criteria criteria = efunctionExample.createCriteria();
        criteria.andFcodeEqualTo(function.getFcode());

        List<Efunction> efunctionList = efunctionMapper.selectByExample(efunctionExample);
        if (efunctionList!=null&&efunctionList.size()>0){
            baseResult.setSuccess(false);
            baseResult.setMessage("功能编码已存在,请重新输入");
            return baseResult;
        }
        if (function.getFparentid()==null){
            function.setFparentid(0);
        }
        //设置该节点为最终叶节点,因为它是新节点
        function.setFremark2("YES");
        int result = efunctionMapper.insert(function);
        if (result == 0) {
            baseResult.setSuccess(false);
            baseResult.setMessage("新增失败,请稍后再试");
        } else {
            baseResult.setSuccess(true);
            baseResult.setMessage("新增成功");
            //更新该父节点的状态
            efunctionMapper.updateStateByFid(function.getFparentid(),"NO");
        }
        return baseResult;
    }

    @Override
    @Transactional
    public BaseResult deleteEfunctionByFid(int fid) {
        logger.info("功能删除方法开始,入参: "+fid);
        BaseResult baseResult = new BaseResult();
        if (fid==1||fid==5){
            baseResult.setSuccess(false);
            baseResult.setMessage("该功能很重要,不能被删除");
            return baseResult;
        }
        try {
            //先判断改节点是否有子类,如果有也删除
            EfunctionExample efunctionExample = new EfunctionExample();
            EfunctionExample.Criteria criteria = efunctionExample.createCriteria();
            criteria.andFparentidEqualTo(fid);
            //获取List<Efunction>的结果集
            List<Efunction> efunctionList = efunctionMapper.selectByExample(efunctionExample);
            if (efunctionList != null && efunctionList.size() > 0) {
                //删除子功能的功能角色关系表
                for (Efunction ef : efunctionList) {
                    RoleFunctionExample roleFunctionExample = new RoleFunctionExample();
                    RoleFunctionExample.Criteria criteria1 = roleFunctionExample.createCriteria();
                    criteria1.andFidEqualTo(ef.getFid());
                    roleFunctionMapper.deleteByExample(roleFunctionExample);
                    //删除所有子功能
                    efunctionMapper.deleteByPrimaryKey(ef.getFid());
                }
            }
            //查询跟该功能相关的中间表信息并删除这些信息
            RoleFunctionExample roleFunctionExample = new RoleFunctionExample();
            roleFunctionExample.createCriteria().andFidEqualTo(fid);
            roleFunctionMapper.deleteByExample(roleFunctionExample);
            efunctionMapper.deleteByPrimaryKey(fid);

            baseResult.setMessage("该功能与子功能以及相关的中间表信息删除成功");
            baseResult.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            baseResult.setMessage("删除失败");
            baseResult.setSuccess(false);
        }
        logger.info("删除结束，出参："+baseResult);
        return baseResult;
    }

    @Override
    @Transactional
    public BaseResult batchDelete(List<Integer> fids) {
        logger.info("批量删除开始，入参：fids"+fids);
        BaseResult baseResult = new BaseResult();
        try {
            for (int fid : fids) {
                BaseResult result = deleteEfunctionByFid(fid);
                if (!result.isSuccess()) {
                    throw new Exception();
                }
            }
            baseResult.setSuccess(true);
            baseResult.setMessage("批量删除成功");
        } catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            baseResult.setSuccess(false);
            baseResult.setMessage("批量删除失败");
        }
        logger.info("批量删除结束，出参："+baseResult);
        return baseResult;
    }

    @Override
    public List<Efunction> selectEfunctionsByFlevel(int flevel) {
        logger.info("根据不同的功能等级查询显示可选择的功能父类方法开始,入参: "+flevel);
        String requirement = String.valueOf(flevel - 1);
        EfunctionExample efunctionExample = new EfunctionExample();
        EfunctionExample.Criteria criteria = efunctionExample.createCriteria();
        if (flevel!=-1) {
            criteria.andFlevelEqualTo(requirement);
        }
        return efunctionMapper.selectByExample(efunctionExample);
    }

    @Override
    public List<Efunction> findAllFunctions() {
        return efunctionMapper.selectByExample(new EfunctionExample());
    }

    @Override
    public List<Integer> findChildrenIdByFid(int fid) {
        logger.info("根据父fid查询该功能有哪些子功能的方法开始,入参: "+fid);
        //获取所有Efunction
        List<Efunction> allEfunctions = findAllFunctions();
        //得到装有fid的List<Integer>类型的结果集
        List<Integer> list = searchTreeLeaf(allEfunctions, fid, new ArrayList<Integer>());
        logger.info("根据父fid查询该功能有哪些子功能的方法结束,出参: "+list);
        return list;
    }
    //遍历树
    public List<Integer> searchTreeLeaf(List<Efunction> efunctionList,int parentId,List<Integer> list){
        //logger.info("遍历树方法: fid "+parentId);
        for (Efunction efunction : efunctionList){
            if(efunction.getFparentid()==parentId) {
                list.add(efunction.getFid());
                //如果该节点下面还有子节点
                if ("NO".equals(efunction.getFremark2())) {
                    searchTreeLeaf(efunctionList, efunction.getFid(), list);
                }
            }
        }
        return list;
    }

    @Override
    public List<Integer> findAllParentIdsByFid(int fid) {
        logger.info("根据子fid查询该功能有哪些父功能的方法开始,入参: "+fid);
        //根据fid 获取efunction
        Efunction efunction = efunctionMapper.selectByPrimaryKey(fid);
        //获取所有Efunction
        List<Efunction> allEfunctions = findAllFunctions();
        //得到装有fid的List<Integer>类型的结果集
        List<Integer> list = searchTreeRoot(allEfunctions, efunction, new ArrayList<Integer>());
        logger.info("根据子fid查询该功能有哪些父功能的方法结束,出参: "+list);
        return list;
    }

    public List<Integer> searchTreeRoot(List<Efunction> efunctionList,Efunction fun,List<Integer> list){
        for (Efunction efunction : efunctionList){
            if(efunction.getFid()==fun.getFparentid()) {
                list.add(efunction.getFid());
                //如果该节点上面面还有父节点
                if (!"1".equals(efunction.getFlevel())) {
                    searchTreeRoot(efunctionList, efunction, list);
                }
            }
        }
        return list;
    }
}
