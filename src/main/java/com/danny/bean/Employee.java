package com.danny.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.danny.util.JsonListUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Employee {
    private Integer eid;

    private String ename;

    private Integer esex;

    private Integer eage;

    private String ephoneno;

    private Date ehiredate;

    private String ehiredateStr;

    private String ejobno;

    private String epassword;

    //当前页码
    private int pageIndex;
    //当前条数
    private int pageSize;

    private String sortField;

    private String sortOrder;

    private String eremark1;

    private String eremark2;

    private String eremark3;


    public Employee(Integer eid, String ename, Integer esex, Integer eage, String ephoneno, Date ehiredate, String ejobno, String epassword, String eremark1, String eremark2, String eremark3) {
        this.eid = eid;
        this.ename = ename;
        this.esex = esex;
        this.eage = eage;
        this.ephoneno = ephoneno;
        this.ehiredate = ehiredate;
        this.ejobno = ejobno;
        this.epassword = epassword;
        this.eremark1 = eremark1;
        this.eremark2 = eremark2;
        this.eremark3 = eremark3;
    }

    public Employee() {
        super();
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public Integer getEsex() {
        return esex;
    }

    public void setEsex(Integer esex) {
        this.esex = esex;
    }

    public Integer getEage() {
        return eage;
    }

    public void setEage(Integer eage) {
        this.eage = eage;
    }

    public String getEphoneno() {
        return ephoneno;
    }

    public void setEphoneno(String ephoneno) {
        this.ephoneno = ephoneno == null ? null : ephoneno.trim();
    }

    public Date getEhiredate() {
        return ehiredate;
    }

    public void setEhiredate(Date ehiredate) {
        this.ehiredate = ehiredate;
    }

    public String getEjobno() {
        return ejobno;
    }

    public void setEjobno(String ejobno) {
        this.ejobno = ejobno == null ? null : ejobno.trim();
    }

    public String getEpassword() {
        return epassword;
    }

    public void setEpassword(String epassword) {
        this.epassword = epassword == null ? null : epassword.trim();
    }

    public String getEremark1() {
        return eremark1;
    }

    public void setEremark1(String eremark1) {
        this.eremark1 = eremark1 == null ? null : eremark1.trim();
    }

    public String getEremark2() {
        return eremark2;
    }

    public void setEremark2(String eremark2) {
        this.eremark2 = eremark2 == null ? null : eremark2.trim();
    }

    public String getEremark3() {
        return eremark3;
    }

    public void setEremark3(String eremark3) {
        this.eremark3 = eremark3 == null ? null : eremark3.trim();
    }

    public String getEhiredateStr() {
        return ehiredateStr;
    }

    public void setEhiredateStr(String ehiredateStr) {
        this.ehiredateStr = ehiredateStr;
    }

    public int getPageIndex() {
        if (pageIndex==1){
            return 0;
        } else {
            return (pageIndex-1)*pageSize;
        }
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    //初始化排序列
    public String getSortField() {
        if (sortField == null || "".equals(sortField)){
            return "eid";
        }
        if ("ehiredateStr".equals(sortField)){
            return "ehiredate";
        }
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        if (sortField == null || "".equals(sortField)){
            return "asc";
        }
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", esex=" + esex +
                ", eage=" + eage +
                ", ephoneno='" + ephoneno + '\'' +
                ", ehiredate=" + ehiredate +
                ", ehiredateStr='" + ehiredateStr + '\'' +
                ", ejobno='" + ejobno + '\'' +
                ", epassword='" + epassword + '\'' +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", sortField='" + sortField + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                ", eremark1='" + eremark1 + '\'' +
                ", eremark2='" + eremark2 + '\'' +
                ", eremark3='" + eremark3 + '\'' +
                '}';
    }
}