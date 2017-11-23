package com.sunrise.ucp.dal.gen.model;

import java.io.Serializable;

public class TableConfigVO implements Serializable {
    private Integer id;

    private String tablename;

    private String dbname;

    private String tablecname;

    private String dbcname;

    private String voname;

    private String appcode;

    private String uniqcode;

    private String memo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname == null ? null : dbname.trim();
    }

    public String getTablecname() {
        return tablecname;
    }

    public void setTablecname(String tablecname) {
        this.tablecname = tablecname == null ? null : tablecname.trim();
    }

    public String getDbcname() {
        return dbcname;
    }

    public void setDbcname(String dbcname) {
        this.dbcname = dbcname == null ? null : dbcname.trim();
    }

    public String getVoname() {
        return voname;
    }

    public void setVoname(String voname) {
        this.voname = voname == null ? null : voname.trim();
    }

    public String getAppcode() {
        return appcode;
    }

    public void setAppcode(String appcode) {
        this.appcode = appcode == null ? null : appcode.trim();
    }

    public String getUniqcode() {
        return uniqcode;
    }

    public void setUniqcode(String uniqcode) {
        this.uniqcode = uniqcode == null ? null : uniqcode.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tablename=").append(tablename);
        sb.append(", dbname=").append(dbname);
        sb.append(", tablecname=").append(tablecname);
        sb.append(", dbcname=").append(dbcname);
        sb.append(", voname=").append(voname);
        sb.append(", appcode=").append(appcode);
        sb.append(", uniqcode=").append(uniqcode);
        sb.append(", memo=").append(memo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TableConfigVO other = (TableConfigVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTablename() == null ? other.getTablename() == null : this.getTablename().equals(other.getTablename()))
            && (this.getDbname() == null ? other.getDbname() == null : this.getDbname().equals(other.getDbname()))
            && (this.getTablecname() == null ? other.getTablecname() == null : this.getTablecname().equals(other.getTablecname()))
            && (this.getDbcname() == null ? other.getDbcname() == null : this.getDbcname().equals(other.getDbcname()))
            && (this.getVoname() == null ? other.getVoname() == null : this.getVoname().equals(other.getVoname()))
            && (this.getAppcode() == null ? other.getAppcode() == null : this.getAppcode().equals(other.getAppcode()))
            && (this.getUniqcode() == null ? other.getUniqcode() == null : this.getUniqcode().equals(other.getUniqcode()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTablename() == null) ? 0 : getTablename().hashCode());
        result = prime * result + ((getDbname() == null) ? 0 : getDbname().hashCode());
        result = prime * result + ((getTablecname() == null) ? 0 : getTablecname().hashCode());
        result = prime * result + ((getDbcname() == null) ? 0 : getDbcname().hashCode());
        result = prime * result + ((getVoname() == null) ? 0 : getVoname().hashCode());
        result = prime * result + ((getAppcode() == null) ? 0 : getAppcode().hashCode());
        result = prime * result + ((getUniqcode() == null) ? 0 : getUniqcode().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        return result;
    }
}