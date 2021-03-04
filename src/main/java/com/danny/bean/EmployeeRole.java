package com.danny.bean;

public class EmployeeRole {
    private Integer erid;

    private Integer eid;

    private Integer rid;

    public EmployeeRole(Integer erid, Integer eid, Integer rid) {
        this.erid = erid;
        this.eid = eid;
        this.rid = rid;
    }

    public EmployeeRole(Integer eid, Integer rid) {
        this.eid = eid;
        this.rid = rid;
    }

    public EmployeeRole() {
        super();
    }

    public Integer getErid() {
        return erid;
    }

    public void setErid(Integer erid) {
        this.erid = erid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "EmployeeRole{" +
                "erid=" + erid +
                ", eid=" + eid +
                ", rid=" + rid +
                '}';
    }
}