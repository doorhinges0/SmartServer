package com.dtsjy.mdboss.common.dal.gen.model;

import java.io.Serializable;
import java.util.Date;

public class ExceptionlogVO implements Serializable {
    private Integer id;

    private String hostid;

    private String appcode;

    private Date createtime;

    private String servicemethod;

    private String exceptionmsg;

    private String serialno;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHostid() {
        return hostid;
    }

    public void setHostid(String hostid) {
        this.hostid = hostid == null ? null : hostid.trim();
    }

    public String getAppcode() {
        return appcode;
    }

    public void setAppcode(String appcode) {
        this.appcode = appcode == null ? null : appcode.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getServicemethod() {
        return servicemethod;
    }

    public void setServicemethod(String servicemethod) {
        this.servicemethod = servicemethod == null ? null : servicemethod.trim();
    }

    public String getExceptionmsg() {
        return exceptionmsg;
    }

    public void setExceptionmsg(String exceptionmsg) {
        this.exceptionmsg = exceptionmsg == null ? null : exceptionmsg.trim();
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno == null ? null : serialno.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", hostid=").append(hostid);
        sb.append(", appcode=").append(appcode);
        sb.append(", createtime=").append(createtime);
        sb.append(", servicemethod=").append(servicemethod);
        sb.append(", exceptionmsg=").append(exceptionmsg);
        sb.append(", serialno=").append(serialno);
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
        ExceptionlogVO other = (ExceptionlogVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHostid() == null ? other.getHostid() == null : this.getHostid().equals(other.getHostid()))
            && (this.getAppcode() == null ? other.getAppcode() == null : this.getAppcode().equals(other.getAppcode()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getServicemethod() == null ? other.getServicemethod() == null : this.getServicemethod().equals(other.getServicemethod()))
            && (this.getExceptionmsg() == null ? other.getExceptionmsg() == null : this.getExceptionmsg().equals(other.getExceptionmsg()))
            && (this.getSerialno() == null ? other.getSerialno() == null : this.getSerialno().equals(other.getSerialno()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHostid() == null) ? 0 : getHostid().hashCode());
        result = prime * result + ((getAppcode() == null) ? 0 : getAppcode().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getServicemethod() == null) ? 0 : getServicemethod().hashCode());
        result = prime * result + ((getExceptionmsg() == null) ? 0 : getExceptionmsg().hashCode());
        result = prime * result + ((getSerialno() == null) ? 0 : getSerialno().hashCode());
        return result;
    }
}