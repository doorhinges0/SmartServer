package com.sunrise.ucp.dal.gen.model;

import java.io.Serializable;
import java.util.Date;

public class RoleVO implements Serializable {
    private Integer id;

    private String rolecode;

    private String rolename;

    private String orgcode;

    private String rolestate;

    private String roletype;

    private Date createtime;

    private String roledesc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode == null ? null : orgcode.trim();
    }

    public String getRolestate() {
        return rolestate;
    }

    public void setRolestate(String rolestate) {
        this.rolestate = rolestate == null ? null : rolestate.trim();
    }

    public String getRoletype() {
        return roletype;
    }

    public void setRoletype(String roletype) {
        this.roletype = roletype == null ? null : roletype.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc == null ? null : roledesc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", rolecode=").append(rolecode);
        sb.append(", rolename=").append(rolename);
        sb.append(", orgcode=").append(orgcode);
        sb.append(", rolestate=").append(rolestate);
        sb.append(", roletype=").append(roletype);
        sb.append(", createtime=").append(createtime);
        sb.append(", roledesc=").append(roledesc);
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
        RoleVO other = (RoleVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRolecode() == null ? other.getRolecode() == null : this.getRolecode().equals(other.getRolecode()))
            && (this.getRolename() == null ? other.getRolename() == null : this.getRolename().equals(other.getRolename()))
            && (this.getOrgcode() == null ? other.getOrgcode() == null : this.getOrgcode().equals(other.getOrgcode()))
            && (this.getRolestate() == null ? other.getRolestate() == null : this.getRolestate().equals(other.getRolestate()))
            && (this.getRoletype() == null ? other.getRoletype() == null : this.getRoletype().equals(other.getRoletype()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getRoledesc() == null ? other.getRoledesc() == null : this.getRoledesc().equals(other.getRoledesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRolecode() == null) ? 0 : getRolecode().hashCode());
        result = prime * result + ((getRolename() == null) ? 0 : getRolename().hashCode());
        result = prime * result + ((getOrgcode() == null) ? 0 : getOrgcode().hashCode());
        result = prime * result + ((getRolestate() == null) ? 0 : getRolestate().hashCode());
        result = prime * result + ((getRoletype() == null) ? 0 : getRoletype().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getRoledesc() == null) ? 0 : getRoledesc().hashCode());
        return result;
    }
}