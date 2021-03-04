package com.danny.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.danny.bean.Efunction;
import com.danny.bean.Employee;
import com.danny.service.FunctionService;
import com.danny.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("function")
public class FunctionController {
    @Autowired
    private FunctionService functionService;
    
    @RequestMapping("getCurrentEmployeeFunctions")
    @ResponseBody
    public JSONArray getCurrentEmployeeFunctions(HttpSession session){
        //获取当前登录用户
        Employee employee = (Employee) session.getAttribute("employee");
        List<Efunction> efunctionList = functionService.findFunctionsByEid(employee.getEid());
        //JSONArray jsonArray = functionService.convert(efunctionList);
        JSONArray jsonArray = functionService.convert2(efunctionList,0);
        return jsonArray;
    }

    @RequestMapping("findEfunctionsByCondition")
    @ResponseBody
    public JSONObject findEfunctionsByCondition(Efunction function){
        List<Efunction> functionList = functionService.findEfunctionsByCondition(function);
        int functionsCount = functionService.countEfunctionsByCondition(function);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", functionList);
        jsonObject.put("itemsCount", functionsCount);
        return jsonObject;
    }

    @RequestMapping("updateEfunctionByFid")
    @ResponseBody
    public BaseResult updateEfunctionByFid(Efunction function){
        return functionService.updateEfunctionByFid(function);
    }

    @RequestMapping("insertEfunction")
    @ResponseBody
    public BaseResult insertEfunction(Efunction function){
        return functionService.insertEfunction(function);
    }

    @RequestMapping("deleteEfunctionByFid")
    @ResponseBody
    public BaseResult deleteEfunctionByFid(int fid){
        return functionService.deleteEfunctionByFid(fid);
    }

    @RequestMapping("batchDelete")
    @ResponseBody
    public BaseResult batchDelete(@RequestParam("fid[]") List<Integer> fids){
        return functionService.batchDelete(fids);
    }

    @RequestMapping("selectEfunctionsByFlevel")
    @ResponseBody
    public JSONObject selectEfunctionsByFlevel(int flevel){
        List<Efunction> efunctionList = functionService.selectEfunctionsByFlevel(flevel);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("efunctionList",efunctionList);
        return jsonObject;
    }

    @RequestMapping("findChildrenIdByFid")
    @ResponseBody
    public JSONObject findChildrenIdByFid(int fid){
        List<Integer> childrenIdByFid = functionService.findChildrenIdByFid(fid);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("childrenIdByFid",childrenIdByFid);
        return jsonObject;
    }

    @RequestMapping("findAllParentIdsByFid")
    @ResponseBody
    public JSONObject findAllParentIdsByFid(int fid){
        List<Integer> allParentIdsByFid = functionService.findAllParentIdsByFid(fid);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("allParentIdsByFid",allParentIdsByFid);
        return jsonObject;
    }
    
}
