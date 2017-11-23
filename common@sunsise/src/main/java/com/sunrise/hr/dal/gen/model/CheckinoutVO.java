package com.sunrise.hr.dal.gen.model;

import java.io.Serializable;
import java.util.Date;

public class CheckinoutVO implements Serializable {
    private Integer id;

    private String userid;

    private String pin;

    private Date checktime;

    private String checktype;

    private Integer verifycode;

    private String sn;

    private String sensorid;

    private String workcode;

    private String reserved;

    private String sn_name;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin == null ? null : pin.trim();
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public String getChecktype() {
        return checktype;
    }

    public void setChecktype(String checktype) {
        this.checktype = checktype == null ? null : checktype.trim();
    }

    public Integer getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(Integer verifycode) {
        this.verifycode = verifycode;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getSensorid() {
        return sensorid;
    }

    public void setSensorid(String sensorid) {
        this.sensorid = sensorid == null ? null : sensorid.trim();
    }

    public String getWorkcode() {
        return workcode;
    }

    public void setWorkcode(String workcode) {
        this.workcode = workcode == null ? null : workcode.trim();
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved == null ? null : reserved.trim();
    }

    public String getSn_name() {
        return sn_name;
    }

    public void setSn_name(String sn_name) {
        this.sn_name = sn_name == null ? null : sn_name.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", pin=").append(pin);
        sb.append(", checktime=").append(checktime);
        sb.append(", checktype=").append(checktype);
        sb.append(", verifycode=").append(verifycode);
        sb.append(", sn=").append(sn);
        sb.append(", sensorid=").append(sensorid);
        sb.append(", workcode=").append(workcode);
        sb.append(", reserved=").append(reserved);
        sb.append(", sn_name=").append(sn_name);
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
        CheckinoutVO other = (CheckinoutVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getPin() == null ? other.getPin() == null : this.getPin().equals(other.getPin()))
            && (this.getChecktime() == null ? other.getChecktime() == null : this.getChecktime().equals(other.getChecktime()))
            && (this.getChecktype() == null ? other.getChecktype() == null : this.getChecktype().equals(other.getChecktype()))
            && (this.getVerifycode() == null ? other.getVerifycode() == null : this.getVerifycode().equals(other.getVerifycode()))
            && (this.getSn() == null ? other.getSn() == null : this.getSn().equals(other.getSn()))
            && (this.getSensorid() == null ? other.getSensorid() == null : this.getSensorid().equals(other.getSensorid()))
            && (this.getWorkcode() == null ? other.getWorkcode() == null : this.getWorkcode().equals(other.getWorkcode()))
            && (this.getReserved() == null ? other.getReserved() == null : this.getReserved().equals(other.getReserved()))
            && (this.getSn_name() == null ? other.getSn_name() == null : this.getSn_name().equals(other.getSn_name()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getPin() == null) ? 0 : getPin().hashCode());
        result = prime * result + ((getChecktime() == null) ? 0 : getChecktime().hashCode());
        result = prime * result + ((getChecktype() == null) ? 0 : getChecktype().hashCode());
        result = prime * result + ((getVerifycode() == null) ? 0 : getVerifycode().hashCode());
        result = prime * result + ((getSn() == null) ? 0 : getSn().hashCode());
        result = prime * result + ((getSensorid() == null) ? 0 : getSensorid().hashCode());
        result = prime * result + ((getWorkcode() == null) ? 0 : getWorkcode().hashCode());
        result = prime * result + ((getReserved() == null) ? 0 : getReserved().hashCode());
        result = prime * result + ((getSn_name() == null) ? 0 : getSn_name().hashCode());
        return result;
    }
}