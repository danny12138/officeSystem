package com.danny.bean;

public class Role {
    private Integer rid;

    private String rcode;

    private String rname;

    private int pageIndex;

    private int pageSize;

    private String sortField;

    private String sortOrder;

    private String rremark1;

    private String rremark2;

    private String rremark3;


    public Role(Integer rid, String rcode, String rname, String rremark1, String rremark2, String rremark3) {
        this.rid = rid;
        this.rcode = rcode;
        this.rname = rname;
        this.rremark1 = rremark1;
        this.rremark2 = rremark2;
        this.rremark3 = rremark3;
    }

    public Role() {
        super();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode == null ? null : rcode.trim();
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    public String getRremark1() {
        return rremark1;
    }

    public void setRremark1(String rremark1) {
        this.rremark1 = rremark1 == null ? null : rremark1.trim();
    }

    public String getRremark2() {
        return rremark2;
    }

    public void setRremark2(String rremark2) {
        this.rremark2 = rremark2 == null ? null : rremark2.trim();
    }

    public String getRremark3() {
        return rremark3;
    }

    public void setRremark3(String rremark3) {
        this.rremark3 = rremark3 == null ? null : rremark3.trim();
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

    public String getSortField() {
        if (sortField == null || "".equals(sortField)){
            return "rid";
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
        return "Role{" +
                "rid=" + rid +
                ", rcode='" + rcode + '\'' +
                ", rname='" + rname + '\'' +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", sortField='" + sortField + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                ", rremark1='" + rremark1 + '\'' +
                ", rremark2='" + rremark2 + '\'' +
                ", rremark3='" + rremark3 + '\'' +
                '}';
    }
}