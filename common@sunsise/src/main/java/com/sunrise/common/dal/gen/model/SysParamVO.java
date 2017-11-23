package com.sunrise.common.dal.gen.model;

import java.io.Serializable;

public class SysParamVO implements Serializable {
    private Integer id;

    private String paramcode;

    private String paramtype;

    private String paramname;

    private String value;

    private String appcode;

    private String paramdesc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParamcode() {
        return paramcode;
    }

    public void setParamcode(String paramcode) {
        this.paramcode = paramcode == null ? null : paramcode.trim();
    }

    public String getParamtype() {
        return paramtype;
    }

    public void setParamtype(String paramtype) {
        this.paramtype = paramtype == null ? null : paramtype.trim();
    }

    public String getParamname() {
        return paramname;
    }

    public void setParamname(String paramname) {
        this.paramname = paramname == null ? null : paramname.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getAppcode() {
        return appcode;
    }

    public void setAppcode(String appcode) {
        this.appcode = appcode == null ? null : appcode.trim();
    }

    public String getParamdesc() {
        return paramdesc;
    }

    public void setParamdesc(String paramdesc) {
        this.paramdesc = paramdesc == null ? null : paramdesc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", paramcode=").append(paramcode);
        sb.append(", paramtype=").append(paramtype);
        sb.append(", paramname=").append(paramname);
        sb.append(", value=").append(value);
        sb.append(", appcode=").append(appcode);
        sb.append(", paramdesc=").append(paramdesc);
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
        SysParamVO other = (SysParamVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParamcode() == null ? other.getParamcode() == null : this.getParamcode().equals(other.getParamcode()))
            && (this.getParamtype() == null ? other.getParamtype() == null : this.getParamtype().equals(other.getParamtype()))
            && (this.getParamname() == null ? other.getParamname() == null : this.getParamname().equals(other.getParamname()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getAppcode() == null ? other.getAppcode() == null : this.getAppcode().equals(other.getAppcode()))
            && (this.getParamdesc() == null ? other.getParamdesc() == null : this.getParamdesc().equals(other.getParamdesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParamcode() == null) ? 0 : getParamcode().hashCode());
        result = prime * result + ((getParamtype() == null) ? 0 : getParamtype().hashCode());
        result = prime * result + ((getParamname() == null) ? 0 : getParamname().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getAppcode() == null) ? 0 : getAppcode().hashCode());
        result = prime * result + ((getParamdesc() == null) ? 0 : getParamdesc().hashCode());
        return result;
    }
}