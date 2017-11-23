package com.sunrise.ucp.dal.gen.model;

import java.io.Serializable;

public class UsergroupMemberVO implements Serializable {
    private Integer id;

    private String groupcode;

    private String usercode;

    private String menbername;

    private String membertype;

    private Byte sortorder;

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

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getMenbername() {
        return menbername;
    }

    public void setMenbername(String menbername) {
        this.menbername = menbername == null ? null : menbername.trim();
    }

    public String getMembertype() {
        return membertype;
    }

    public void setMembertype(String membertype) {
        this.membertype = membertype == null ? null : membertype.trim();
    }

    public Byte getSortorder() {
        return sortorder;
    }

    public void setSortorder(Byte sortorder) {
        this.sortorder = sortorder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", groupcode=").append(groupcode);
        sb.append(", usercode=").append(usercode);
        sb.append(", menbername=").append(menbername);
        sb.append(", membertype=").append(membertype);
        sb.append(", sortorder=").append(sortorder);
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
        UsergroupMemberVO other = (UsergroupMemberVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGroupcode() == null ? other.getGroupcode() == null : this.getGroupcode().equals(other.getGroupcode()))
            && (this.getUsercode() == null ? other.getUsercode() == null : this.getUsercode().equals(other.getUsercode()))
            && (this.getMenbername() == null ? other.getMenbername() == null : this.getMenbername().equals(other.getMenbername()))
            && (this.getMembertype() == null ? other.getMembertype() == null : this.getMembertype().equals(other.getMembertype()))
            && (this.getSortorder() == null ? other.getSortorder() == null : this.getSortorder().equals(other.getSortorder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGroupcode() == null) ? 0 : getGroupcode().hashCode());
        result = prime * result + ((getUsercode() == null) ? 0 : getUsercode().hashCode());
        result = prime * result + ((getMenbername() == null) ? 0 : getMenbername().hashCode());
        result = prime * result + ((getMembertype() == null) ? 0 : getMembertype().hashCode());
        result = prime * result + ((getSortorder() == null) ? 0 : getSortorder().hashCode());
        return result;
    }
}