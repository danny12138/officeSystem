package com.danny.controller;

import com.alibaba.fastjson.JSONObject;
import com.danny.bean.Employee;
import com.danny.bean.Role;
import com.danny.service.EmployeeService;
import com.danny.service.RoleService;
import com.danny.util.BaseResult;
import com.danny.util.EmployeeResult;
import com.danny.util.MyDateConverter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RoleService roleService;

    /**
     * 登录校验
     *
     * @param ejobno
     * @param epassword
     * @return
     */
    @RequestMapping("loginCheck")
    @ResponseBody
    public EmployeeResult loginCheck(String ejobno, String epassword) {
        EmployeeResult result = employeeService.shiroLogin(ejobno, epassword);
        //将登陆成功的用户存放到session中
        //session.setAttribute("employee", result.getEmployee());
        return result;
    }

    /**
     * 获取当前登录用户
     * @return
     */
    @RequestMapping("getCurrentEmployee")
    @ResponseBody
    public Employee getCurrentEmployee(){
        Session session = SecurityUtils.getSubject().getSession();
        return (Employee) session.getAttribute("employee");
    }

    /**
     * 退出登录
     */
    @RequestMapping("logout")
    @ResponseBody
    public void logout() {
        //退出登录移除相关数据
        SecurityUtils.getSubject().logout();
    }
    /**
     * 根据条件获取员工信息
     *
     * @param employee
     * @return
     */
    @RequestMapping("findEmployeesByCondition")
    @ResponseBody
    public JSONObject findEmployeesByCondition(Employee employee) {
        List<Employee> employeeList = employeeService.findEmployeesByCondition(employee);
        int employeesCount = employeeService.countEmployeesByCondition(employee);
        JSONObject jsonObject = new JSONObject();
        // loadData 是一个返回数据数组或jQuery promise的函数，该数组将用一个数据数组来解析（当pageLoading为true而不是object时，
        // 应该返回结构{data:[items]，itemsCount:[total items count]}）。当pageLoading为true时接受筛选器参数，包括当前筛选器选项和分页参数。
        jsonObject.put("data", employeeList);
        jsonObject.put("itemsCount", employeesCount);
        return jsonObject;
    }

    /**
     * 根据eid更新员工信息
     *
     * @param employee
     * @return
     */
    @RequestMapping("updateEmployeeByEid")
    @ResponseBody
    public BaseResult updateEmployeeByEid(Employee employee) {
        //日期类型转换
        MyDateConverter myDateConverter = new MyDateConverter();
        Date date = myDateConverter.convert(employee.getEhiredateStr());
        employee.setEhiredate(date);
        return employeeService.updateEmployeeByEid(employee);
    }

    /**
     * 新增员工
     * @param employee
     * @return
     */
    @RequestMapping("insertEmployee")
    @ResponseBody
    public BaseResult insertEmployee(Employee employee) {
        //日期类型转换
        MyDateConverter myDateConverter = new MyDateConverter();
        Date date = myDateConverter.convert(employee.getEhiredateStr());
        employee.setEhiredate(date);
        //(初始密码为员工号)
        employee.setEpassword(employee.getEjobno());

        return employeeService.insertEmployee(employee);
    }

    /**
     * 删除员工
     * @param eid
     * @return
     */
    @RequestMapping("deleteEmployeeByEid")
    @ResponseBody
    public BaseResult deleteEmployeeByEid(int eid){
        Employee currentEmployee = (Employee) SecurityUtils.getSubject().getSession().getAttribute("employee");
        return employeeService.deleteEmployeeByEid(eid,currentEmployee.getEid());
    }

    /**
     * 批量删除员工
     * @param eids
     * @return
     */
    @RequestMapping("batchDelete")
    @ResponseBody
    public BaseResult batchDelete(@RequestParam("eid[]") List<Integer> eids){
        Employee currentEmployee = (Employee) SecurityUtils.getSubject().getSession().getAttribute("employee");
        return employeeService.batchDelete(eids,currentEmployee.getEid());
    }



    @RequestMapping("selectAllRoles")
    @ResponseBody
    public JSONObject selectAllRoles() {
        List<Role> roleList = roleService.selectAllRoles();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("roleList", roleList);
        return jsonObject;
    }

    /**
     * 当前员工修改密码
     * @param eid
     * @param epassword
     * @return
     */
    @RequestMapping("resetPassword")
    @ResponseBody
    public BaseResult resetPassword(int eid, String epassword){
        return employeeService.updatePassword(eid,epassword);
    }

    @RequestMapping("updateEmployeeRole")
    @ResponseBody
    public BaseResult updateEmployeeRole(int eid,String newPassword,@RequestParam("data[]") List<Integer> rids){
        return employeeService.updateEmployeeRole(eid,rids,newPassword);
    }

    @RequestMapping("checkOldPassword")
    @ResponseBody
    public BaseResult checkOldPassword(int eid, String epassword) {
        return employeeService.checkOldPassword(eid, epassword);
    }

    /**
     * 批量导出员工
     * @param eids
     * @return
     */
    @RequestMapping("export")
    @ResponseBody
    public ResponseEntity<byte[]> export(@RequestParam("eid[]") List<Integer> eids) throws IOException {
        String filename = "employee.xls";
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row title = sheet.createRow(0);
        title.createCell(0).setCellValue("员工id");
        title.createCell(1).setCellValue("员工姓名");
        title.createCell(2).setCellValue("员工性别");
        title.createCell(3).setCellValue("员工年龄");
        title.createCell(4).setCellValue("联系电话");
        title.createCell(5).setCellValue("工号");
        title.createCell(6).setCellValue("入职日期");
        //获取数据库员工信息
//        Employee employee = new Employee();
//        employee.setPageIndex(1);
//        employee.setPageSize(9999);

        //List<Employee> employees = employeeService.findEmployeesByCondition(employee);
        for(int eid:eids){
            Employee employee1 = employeeService.findEmployeeByEid(eid);
            //日期类型转换
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = simpleDateFormat.format(employee1.getEhiredate());
            employee1.setEhiredateStr(date);

            Row nextRow = sheet.createRow(sheet.getLastRowNum()+1);
            nextRow.createCell(0).setCellValue(employee1.getEid());
            nextRow.createCell(1).setCellValue(employee1.getEname());
            nextRow.createCell(2).setCellValue(employee1.getEsex()==0?"男":"女");
            nextRow.createCell(3).setCellValue(employee1.getEage());
            nextRow.createCell(4).setCellValue(employee1.getEphoneno());
            nextRow.createCell(5).setCellValue(employee1.getEjobno());
            nextRow.createCell(6).setCellValue(employee1.getEhiredateStr());
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        byte[] bytes=byteArrayOutputStream.toByteArray();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentDispositionFormData("attachment",filename);

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);

        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("responseEntity",responseEntity);

        return responseEntity;
    }

    /**
     * 下载
     * @return
     */
    @RequestMapping("downloadXLS")
    public ResponseEntity<byte[]> downloadXLS(){
        Session session = SecurityUtils.getSubject().getSession();
        return (ResponseEntity<byte[]>) session.getAttribute("responseEntity");
    }
}
