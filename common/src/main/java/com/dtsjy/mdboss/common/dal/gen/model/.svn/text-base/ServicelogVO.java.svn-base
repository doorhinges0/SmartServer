package com.dtsjy.mdboss.common.dal.gen.model;

import java.io.Serializable;
import java.util.Date;

public class ServicelogVO implements Serializable {
    private Integer id;

    private String usercode;

    private String appcode;

    private String apiname;

    private Date createtime;

    private String inputdata;

    private String outputdata;

    private String serialno;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getAppcode() {
        return appcode;
    }

    public void setAppcode(String appcode) {
        this.appcode = appcode == null ? null : appcode.trim();
    }

    public String getApiname() {
        return apiname;
    }

    public void setApiname(String apiname) {
        this.apiname = apiname == null ? null : apiname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getInputdata() {
        return inputdata;
    }

    public void setInputdata(String inputdata) {
        this.inputdata = inputdata == null ? null : inputdata.trim();
    }

    public String getOutputdata() {
        return outputdata;
    }

    public void setOutputdata(String outputdata) {
        this.outputdata = outputdata == null ? null : outputdata.trim();
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
        sb.append(", usercode=").append(usercode);
        sb.append(", appcode=").append(appcode);
        sb.append(", apiname=").append(apiname);
        sb.append(", createtime=").append(createtime);
        sb.append(", inputdata=").append(inputdata);
        sb.append(", outputdata=").append(outputdata);
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
        ServicelogVO other = (ServicelogVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsercode() == null ? other.getUsercode() == null : this.getUsercode().equals(other.getUsercode()))
            && (this.getAppcode() == null ? other.getAppcode() == null : this.getAppcode().equals(other.getAppcode()))
            && (this.getApiname() == null ? other.getApiname() == null : this.getApiname().equals(other.getApiname()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getInputdata() == null ? other.getInputdata() == null : this.getInputdata().equals(other.getInputdata()))
            && (this.getOutputdata() == null ? other.getOutputdata() == null : this.getOutputdata().equals(other.getOutputdata()))
            && (this.getSerialno() == null ? other.getSerialno() == null : this.getSerialno().equals(other.getSerialno()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsercode() == null) ? 0 : getUsercode().hashCode());
        result = prime * result + ((getAppcode() == null) ? 0 : getAppcode().hashCode());
        result = prime * result + ((getApiname() == null) ? 0 : getApiname().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getInputdata() == null) ? 0 : getInputdata().hashCode());
        result = prime * result + ((getOutputdata() == null) ? 0 : getOutputdata().hashCode());
        result = prime * result + ((getSerialno() == null) ? 0 : getSerialno().hashCode());
        return result;
    }
}