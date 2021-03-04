package com.danny.bean;

public class RoleFunction {
    private Integer rfid;

    private Integer rid;

    private Integer fid;

    public RoleFunction(Integer rfid, Integer rid, Integer fid) {
        this.rfid = rfid;
        this.rid = rid;
        this.fid = fid;
    }

    public RoleFunction(Integer rid, Integer fid) {
        this.rid = rid;
        this.fid = fid;
    }

    public RoleFunction() {
        super();
    }

    public Integer getRfid() {
        return rfid;
    }

    public void setRfid(Integer rfid) {
        this.rfid = rfid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "RoleFunction{" +
                "rfid=" + rfid +
                ", rid=" + rid +
                ", fid=" + fid +
                '}';
    }
}