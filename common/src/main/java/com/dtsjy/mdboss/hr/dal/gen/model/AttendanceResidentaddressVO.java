package com.dtsjy.mdboss.hr.dal.gen.model;

import java.io.Serializable;

public class AttendanceResidentaddressVO implements Serializable {
    private Integer id;

    private String residentaddresscode;

    private String belongprovince;

    private String isspecialzone;

    private String orgcodes;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResidentaddresscode() {
        return residentaddresscode;
    }

    public void setResidentaddresscode(String residentaddresscode) {
        this.residentaddresscode = residentaddresscode == null ? null : residentaddresscode.trim();
    }

    public String getBelongprovince() {
        return belongprovince;
    }

    public void setBelongprovince(String belongprovince) {
        this.belongprovince = belongprovince == null ? null : belongprovince.trim();
    }

    public String getIsspecialzone() {
        return isspecialzone;
    }

    public void setIsspecialzone(String isspecialzone) {
        this.isspecialzone = isspecialzone == null ? null : isspecialzone.trim();
    }

    public String getOrgcodes() {
        return orgcodes;
    }

    public void setOrgcodes(String orgcodes) {
        this.orgcodes = orgcodes == null ? null : orgcodes.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", residentaddresscode=").append(residentaddresscode);
        sb.append(", belongprovince=").append(belongprovince);
        sb.append(", isspecialzone=").append(isspecialzone);
        sb.append(", orgcodes=").append(orgcodes);
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
        AttendanceResidentaddressVO other = (AttendanceResidentaddressVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getResidentaddresscode() == null ? other.getResidentaddresscode() == null : this.getResidentaddresscode().equals(other.getResidentaddresscode()))
            && (this.getBelongprovince() == null ? other.getBelongprovince() == null : this.getBelongprovince().equals(other.getBelongprovince()))
            && (this.getIsspecialzone() == null ? other.getIsspecialzone() == null : this.getIsspecialzone().equals(other.getIsspecialzone()))
            && (this.getOrgcodes() == null ? other.getOrgcodes() == null : this.getOrgcodes().equals(other.getOrgcodes()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getResidentaddresscode() == null) ? 0 : getResidentaddresscode().hashCode());
        result = prime * result + ((getBelongprovince() == null) ? 0 : getBelongprovince().hashCode());
        result = prime * result + ((getIsspecialzone() == null) ? 0 : getIsspecialzone().hashCode());
        result = prime * result + ((getOrgcodes() == null) ? 0 : getOrgcodes().hashCode());
        return result;
    }
}