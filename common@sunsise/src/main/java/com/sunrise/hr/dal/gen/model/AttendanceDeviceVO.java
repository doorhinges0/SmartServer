package com.sunrise.hr.dal.gen.model;

import java.io.Serializable;

public class AttendanceDeviceVO implements Serializable {
    private Integer id;

    private String deviceid;

    private String devicename;

    private String residentaddresscode;
 
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid == null ? null : deviceid.trim();
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename == null ? null : devicename.trim();
    }

    public String getResidentaddresscode() {
        return residentaddresscode;
    }

    public void setResidentaddresscode(String residentaddresscode) {
        this.residentaddresscode = residentaddresscode == null ? null : residentaddresscode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deviceid=").append(deviceid);
        sb.append(", devicename=").append(devicename);
        sb.append(", residentaddresscode=").append(residentaddresscode);
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
        AttendanceDeviceVO other = (AttendanceDeviceVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDeviceid() == null ? other.getDeviceid() == null : this.getDeviceid().equals(other.getDeviceid()))
            && (this.getDevicename() == null ? other.getDevicename() == null : this.getDevicename().equals(other.getDevicename()))
            && (this.getResidentaddresscode() == null ? other.getResidentaddresscode() == null : this.getResidentaddresscode().equals(other.getResidentaddresscode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeviceid() == null) ? 0 : getDeviceid().hashCode());
        result = prime * result + ((getDevicename() == null) ? 0 : getDevicename().hashCode());
        result = prime * result + ((getResidentaddresscode() == null) ? 0 : getResidentaddresscode().hashCode());
        return result;
    }
}