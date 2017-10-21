package com.dtsjy.mdboss.oa.dal.gen.model;

import java.io.Serializable;

public class DriverVO implements Serializable {
    private Integer id;

    private String drivercode;

    private String orgcode;

    private String orgname;

    private String driverno;

    private String drivername;

    private String driverlicence;

    private String mobileno;

    private String email;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrivercode() {
        return drivercode;
    }

    public void setDrivercode(String drivercode) {
        this.drivercode = drivercode == null ? null : drivercode.trim();
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode == null ? null : orgcode.trim();
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public String getDriverno() {
        return driverno;
    }

    public void setDriverno(String driverno) {
        this.driverno = driverno == null ? null : driverno.trim();
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername == null ? null : drivername.trim();
    }

    public String getDriverlicence() {
        return driverlicence;
    }

    public void setDriverlicence(String driverlicence) {
        this.driverlicence = driverlicence == null ? null : driverlicence.trim();
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno == null ? null : mobileno.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", drivercode=").append(drivercode);
        sb.append(", orgcode=").append(orgcode);
        sb.append(", orgname=").append(orgname);
        sb.append(", driverno=").append(driverno);
        sb.append(", drivername=").append(drivername);
        sb.append(", driverlicence=").append(driverlicence);
        sb.append(", mobileno=").append(mobileno);
        sb.append(", email=").append(email);
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
        DriverVO other = (DriverVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDrivercode() == null ? other.getDrivercode() == null : this.getDrivercode().equals(other.getDrivercode()))
            && (this.getOrgcode() == null ? other.getOrgcode() == null : this.getOrgcode().equals(other.getOrgcode()))
            && (this.getOrgname() == null ? other.getOrgname() == null : this.getOrgname().equals(other.getOrgname()))
            && (this.getDriverno() == null ? other.getDriverno() == null : this.getDriverno().equals(other.getDriverno()))
            && (this.getDrivername() == null ? other.getDrivername() == null : this.getDrivername().equals(other.getDrivername()))
            && (this.getDriverlicence() == null ? other.getDriverlicence() == null : this.getDriverlicence().equals(other.getDriverlicence()))
            && (this.getMobileno() == null ? other.getMobileno() == null : this.getMobileno().equals(other.getMobileno()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDrivercode() == null) ? 0 : getDrivercode().hashCode());
        result = prime * result + ((getOrgcode() == null) ? 0 : getOrgcode().hashCode());
        result = prime * result + ((getOrgname() == null) ? 0 : getOrgname().hashCode());
        result = prime * result + ((getDriverno() == null) ? 0 : getDriverno().hashCode());
        result = prime * result + ((getDrivername() == null) ? 0 : getDrivername().hashCode());
        result = prime * result + ((getDriverlicence() == null) ? 0 : getDriverlicence().hashCode());
        result = prime * result + ((getMobileno() == null) ? 0 : getMobileno().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        return result;
    }
}