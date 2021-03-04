package com.danny.bean;

public class Efunction {
    private Integer fid;

    private String fcode;

    private String fname;

    private String furl;

    private String flevel;

    private Integer fparentid;

    private int pageIndex;

    private int pageSize;

    private String sortField;

    private String sortOrder;

    private String fremark1;

    private String fremark2;

    private String fremark3;

    public Efunction(Integer fid, String fcode, String fname, String furl, String flevel, Integer fparentid, String fremark1, String fremark2, String fremark3) {
        this.fid = fid;
        this.fcode = fcode;
        this.fname = fname;
        this.furl = furl;
        this.flevel = flevel;
        this.fparentid = fparentid;
        this.fremark1 = fremark1;
        this.fremark2 = fremark2;
        this.fremark3 = fremark3;
    }

    public Efunction() {
        super();
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode == null ? null : fcode.trim();
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public String getFurl() {
        return furl;
    }

    public void setFurl(String furl) {
        this.furl = furl == null ? null : furl.trim();
    }

    public String getFlevel() {
        return flevel;
    }

    public void setFlevel(String flevel) {
        this.flevel = flevel == null ? null : flevel.trim();
    }

    public Integer getFparentid() {
        return fparentid;
    }

    public void setFparentid(Integer fparentid) {
        this.fparentid = fparentid;
    }

    public String getFremark1() {
        return fremark1;
    }

    public void setFremark1(String fremark1) {
        this.fremark1 = fremark1 == null ? null : fremark1.trim();
    }

    public String getFremark2() {
        return fremark2;
    }

    public void setFremark2(String fremark2) {
        this.fremark2 = fremark2 == null ? null : fremark2.trim();
    }

    public String getFremark3() {
        return fremark3;
    }

    public void setFremark3(String fremark3) {
        this.fremark3 = fremark3 == null ? null : fremark3.trim();
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
            return "fid";
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
        return "Efunction{" +
                "fid=" + fid +
                ", fcode='" + fcode + '\'' +
                ", fname='" + fname + '\'' +
                ", furl='" + furl + '\'' +
                ", flevel='" + flevel + '\'' +
                ", fparentid=" + fparentid +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", sortField='" + sortField + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                ", fremark1='" + fremark1 + '\'' +
                ", fremark2='" + fremark2 + '\'' +
                ", fremark3='" + fremark3 + '\'' +
                '}';
    }
}