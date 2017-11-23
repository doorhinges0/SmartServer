package com.sunrise.ucp.dal.gen.model;

import java.io.Serializable;
import java.util.Date;

public class OrgVO implements Serializable {
    private Integer id;

    private String orgcode;

    private String orgname;

    private String orgtype;

    private String orglevel;

    private String parentcode;

    private Date updatetime;

    private String isenabled;

    private Byte orgorder;

    private String iconclass;

    private String orgdesc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getOrgtype() {
        return orgtype;
    }

    public void setOrgtype(String orgtype) {
        this.orgtype = orgtype == null ? null : orgtype.trim();
    }

    public String getOrglevel() {
        return orglevel;
    }

    public void setOrglevel(String orglevel) {
        this.orglevel = orglevel == null ? null : orglevel.trim();
    }

    public String getParentcode() {
        return parentcode;
    }

    public void setParentcode(String parentcode) {
        this.parentcode = parentcode == null ? null : parentcode.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getIsenabled() {
        return isenabled;
    }

    public void setIsenabled(String isenabled) {
        this.isenabled = isenabled == null ? null : isenabled.trim();
    }

    public Byte getOrgorder() {
        return orgorder;
    }

    public void setOrgorder(Byte orgorder) {
        this.orgorder = orgorder;
    }

    public String getIconclass() {
        return iconclass;
    }

    public void setIconclass(String iconclass) {
        this.iconclass = iconclass == null ? null : iconclass.trim();
    }

    public String getOrgdesc() {
        return orgdesc;
    }

    public void setOrgdesc(String orgdesc) {
        this.orgdesc = orgdesc == null ? null : orgdesc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orgcode=").append(orgcode);
        sb.append(", orgname=").append(orgname);
        sb.append(", orgtype=").append(orgtype);
        sb.append(", orglevel=").append(orglevel);
        sb.append(", parentcode=").append(parentcode);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", isenabled=").append(isenabled);
        sb.append(", orgorder=").append(orgorder);
        sb.append(", iconclass=").append(iconclass);
        sb.append(", orgdesc=").append(orgdesc);
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
        OrgVO other = (OrgVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrgcode() == null ? other.getOrgcode() == null : this.getOrgcode().equals(other.getOrgcode()))
            && (this.getOrgname() == null ? other.getOrgname() == null : this.getOrgname().equals(other.getOrgname()))
            && (this.getOrgtype() == null ? other.getOrgtype() == null : this.getOrgtype().equals(other.getOrgtype()))
            && (this.getOrglevel() == null ? other.getOrglevel() == null : this.getOrglevel().equals(other.getOrglevel()))
            && (this.getParentcode() == null ? other.getParentcode() == null : this.getParentcode().equals(other.getParentcode()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getIsenabled() == null ? other.getIsenabled() == null : this.getIsenabled().equals(other.getIsenabled()))
            && (this.getOrgorder() == null ? other.getOrgorder() == null : this.getOrgorder().equals(other.getOrgorder()))
            && (this.getIconclass() == null ? other.getIconclass() == null : this.getIconclass().equals(other.getIconclass()))
            && (this.getOrgdesc() == null ? other.getOrgdesc() == null : this.getOrgdesc().equals(other.getOrgdesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrgcode() == null) ? 0 : getOrgcode().hashCode());
        result = prime * result + ((getOrgname() == null) ? 0 : getOrgname().hashCode());
        result = prime * result + ((getOrgtype() == null) ? 0 : getOrgtype().hashCode());
        result = prime * result + ((getOrglevel() == null) ? 0 : getOrglevel().hashCode());
        result = prime * result + ((getParentcode() == null) ? 0 : getParentcode().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getIsenabled() == null) ? 0 : getIsenabled().hashCode());
        result = prime * result + ((getOrgorder() == null) ? 0 : getOrgorder().hashCode());
        result = prime * result + ((getIconclass() == null) ? 0 : getIconclass().hashCode());
        result = prime * result + ((getOrgdesc() == null) ? 0 : getOrgdesc().hashCode());
        return result;
    }
}