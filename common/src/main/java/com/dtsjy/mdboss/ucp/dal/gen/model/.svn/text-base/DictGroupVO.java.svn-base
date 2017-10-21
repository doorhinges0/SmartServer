package com.dtsjy.mdboss.ucp.dal.gen.model;

import java.io.Serializable;
import java.util.Date;

public class DictGroupVO implements Serializable {
    private Integer id;

    private String groupcode;

    private String groupname;

    private String grouptype;

    private String state;

    private Date effectdate;

    private String groupdesc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode == null ? null : groupcode.trim();
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    public String getGrouptype() {
        return grouptype;
    }

    public void setGrouptype(String grouptype) {
        this.grouptype = grouptype == null ? null : grouptype.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getEffectdate() {
        return effectdate;
    }

    public void setEffectdate(Date effectdate) {
        this.effectdate = effectdate;
    }

    public String getGroupdesc() {
        return groupdesc;
    }

    public void setGroupdesc(String groupdesc) {
        this.groupdesc = groupdesc == null ? null : groupdesc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", groupcode=").append(groupcode);
        sb.append(", groupname=").append(groupname);
        sb.append(", grouptype=").append(grouptype);
        sb.append(", state=").append(state);
        sb.append(", effectdate=").append(effectdate);
        sb.append(", groupdesc=").append(groupdesc);
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
        DictGroupVO other = (DictGroupVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGroupcode() == null ? other.getGroupcode() == null : this.getGroupcode().equals(other.getGroupcode()))
            && (this.getGroupname() == null ? other.getGroupname() == null : this.getGroupname().equals(other.getGroupname()))
            && (this.getGrouptype() == null ? other.getGrouptype() == null : this.getGrouptype().equals(other.getGrouptype()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getEffectdate() == null ? other.getEffectdate() == null : this.getEffectdate().equals(other.getEffectdate()))
            && (this.getGroupdesc() == null ? other.getGroupdesc() == null : this.getGroupdesc().equals(other.getGroupdesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGroupcode() == null) ? 0 : getGroupcode().hashCode());
        result = prime * result + ((getGroupname() == null) ? 0 : getGroupname().hashCode());
        result = prime * result + ((getGrouptype() == null) ? 0 : getGrouptype().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getEffectdate() == null) ? 0 : getEffectdate().hashCode());
        result = prime * result + ((getGroupdesc() == null) ? 0 : getGroupdesc().hashCode());
        return result;
    }
}