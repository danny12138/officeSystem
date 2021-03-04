package com.danny.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.danny.bean.Efunction;
import com.danny.bean.Role;
import com.danny.service.FunctionService;
import com.danny.service.RoleService;
import com.danny.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private FunctionService functionService;

    @RequestMapping("findRolesByCondition")
    @ResponseBody
    public JSONObject findRolesByCondition(Role role){
        List<Role> roleList = roleService.findRolesByCondition(role);
        int rolesCount = roleService.countRolesByCondition(role);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", roleList);
        jsonObject.put("itemsCount", rolesCount);
        return jsonObject;
    }

    @RequestMapping("updateRoleByRid")
    @ResponseBody
    public BaseResult updateRoleByRid(Role role){
        return roleService.updateRoleByRid(role);
    }

    @RequestMapping("insertRole")
    @ResponseBody
    public BaseResult insertRole(Role role){
        return roleService.insertRole(role);
    }

    @RequestMapping("deleteRoleByRid")
    @ResponseBody
    public BaseResult deleteRoleByRid(int rid){
        return roleService.deleteRoleByRid(rid);
    }

    @RequestMapping("batchDelete")
    @ResponseBody
    public BaseResult batchDelete(@RequestParam("rid[]") List<Integer> rids){
        return roleService.batchDelete(rids);
    }

    @RequestMapping("getRoleFunctions")
    @ResponseBody
    public JSONObject getRoleFunctions(int rid){
        JSONObject jsonObject = new JSONObject();
        //获取当前角色的功能信息
        List<Efunction> roleFunctions = roleService.getFunctionsByRid(rid);
        jsonObject.put("roleFunctions",roleFunctions);
        return jsonObject;
    }
    @RequestMapping("getAllFunctions")
    @ResponseBody
    public JSONArray getAllFunctions(){
        //获取所有系统功能
        List<Efunction> efunctionList = functionService.findAllFunctions();
        return functionService.convert2(efunctionList,0);
    }

    @RequestMapping("updateRoleFunction")
    @ResponseBody
    public BaseResult updateRoleFunction(int rid,@RequestParam("data[]") List<Integer> fids){
        return roleService.updateRoleFunction(rid,fids);
    }

    @RequestMapping("findRolesByEid")
    @ResponseBody
    public JSONObject findRolesByEid(int eid){
        List<Role> roleList = roleService.findRolesByEid(eid);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("employeeRole", roleList);
        return jsonObject;
    }

}
