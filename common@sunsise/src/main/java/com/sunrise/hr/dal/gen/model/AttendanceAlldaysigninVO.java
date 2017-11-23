package com.sunrise.hr.dal.gen.model;

import java.io.Serializable;

public class AttendanceAlldaysigninVO implements Serializable {
    private Integer id;

    private String signinmonth;

    private String signindate;

    private String daytype;

    private String daytypename;

    private String usercode;

    private String username;

    private String workno;

    private String orgcode;

    private String orgname;

    private String positionlevel;

    private String residentaddresscode;

    private String belongprovince;

    private String isspecialzone;

    private String signintime;

    private String signintype;

    private String signinaddress;

    private String deviceid;

    private String signinresidentaddress;

    private String signinaddresstype;

    private String residentaddressname;

    private String belongtoorgname;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigninmonth() {
        return signinmonth;
    }

    public void setSigninmonth(String signinmonth) {
        this.signinmonth = signinmonth == null ? null : signinmonth.trim();
    }

    public String getSignindate() {
        return signindate;
    }

    public void setSignindate(String signindate) {
        this.signindate = signindate == null ? null : signindate.trim();
    }

    public String getDaytype() {
        return daytype;
    }

    public void setDaytype(String daytype) {
        this.daytype = daytype == null ? null : daytype.trim();
    }

    public String getDaytypename() {
        return daytypename;
    }

    public void setDaytypename(String daytypename) {
        this.daytypename = daytypename == null ? null : daytypename.trim();
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getWorkno() {
        return workno;
    }

    public void setWorkno(String workno) {
        this.workno = workno == null ? null : workno.trim();
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

    public String getPositionlevel() {
        return positionlevel;
    }

    public void setPositionlevel(String positionlevel) {
        this.positionlevel = positionlevel == null ? null : positionlevel.trim();
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

    public String getSignintime() {
        return signintime;
    }

    public void setSignintime(String signintime) {
        this.signintime = signintime == null ? null : signintime.trim();
    }

    public String getSignintype() {
        return signintype;
    }

    public void setSignintype(String signintype) {
        this.signintype = signintype == null ? null : signintype.trim();
    }

    public String getSigninaddress() {
        return signinaddress;
    }

    public void setSigninaddress(String signinaddress) {
        this.signinaddress = signinaddress == null ? null : signinaddress.trim();
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid == null ? null : deviceid.trim();
    }

    public String getSigninresidentaddress() {
        return signinresidentaddress;
    }

    public void setSigninresidentaddress(String signinresidentaddress) {
        this.signinresidentaddress = signinresidentaddress == null ? null : signinresidentaddress.trim();
    }

    public String getSigninaddresstype() {
        return signinaddresstype;
    }

    public void setSigninaddresstype(String signinaddresstype) {
        this.signinaddresstype = signinaddresstype == null ? null : signinaddresstype.trim();
    }

    public String getResidentaddressname() {
        return residentaddressname;
    }

    public void setResidentaddressname(String residentaddressname) {
        this.residentaddressname = residentaddressname == null ? null : residentaddressname.trim();
    }

    public String getBelongtoorgname() {
        return belongtoorgname;
    }

    public void setBelongtoorgname(String belongtoorgname) {
        this.belongtoorgname = belongtoorgname == null ? null : belongtoorgname.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", signinmonth=").append(signinmonth);
        sb.append(", signindate=").append(signindate);
        sb.append(", daytype=").append(daytype);
        sb.append(", daytypename=").append(daytypename);
        sb.append(", usercode=").append(usercode);
        sb.append(", username=").append(username);
        sb.append(", workno=").append(workno);
        sb.append(", orgcode=").append(orgcode);
        sb.append(", orgname=").append(orgname);
        sb.append(", positionlevel=").append(positionlevel);
        sb.append(", residentaddresscode=").append(residentaddresscode);
        sb.append(", belongprovince=").append(belongprovince);
        sb.append(", isspecialzone=").append(isspecialzone);
        sb.append(", signintime=").append(signintime);
        sb.append(", signintype=").append(signintype);
        sb.append(", signinaddress=").append(signinaddress);
        sb.append(", deviceid=").append(deviceid);
        sb.append(", signinresidentaddress=").append(signinresidentaddress);
        sb.append(", signinaddresstype=").append(signinaddresstype);
        sb.append(", residentaddressname=").append(residentaddressname);
        sb.append(", belongtoorgname=").append(belongtoorgname);
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
        AttendanceAlldaysigninVO other = (AttendanceAlldaysigninVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSigninmonth() == null ? other.getSigninmonth() == null : this.getSigninmonth().equals(other.getSigninmonth()))
            && (this.getSignindate() == null ? other.getSignindate() == null : this.getSignindate().equals(other.getSignindate()))
            && (this.getDaytype() == null ? other.getDaytype() == null : this.getDaytype().equals(other.getDaytype()))
            && (this.getDaytypename() == null ? other.getDaytypename() == null : this.getDaytypename().equals(other.getDaytypename()))
            && (this.getUsercode() == null ? other.getUsercode() == null : this.getUsercode().equals(other.getUsercode()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getWorkno() == null ? other.getWorkno() == null : this.getWorkno().equals(other.getWorkno()))
            && (this.getOrgcode() == null ? other.getOrgcode() == null : this.getOrgcode().equals(other.getOrgcode()))
            && (this.getOrgname() == null ? other.getOrgname() == null : this.getOrgname().equals(other.getOrgname()))
            && (this.getPositionlevel() == null ? other.getPositionlevel() == null : this.getPositionlevel().equals(other.getPositionlevel()))
            && (this.getResidentaddresscode() == null ? other.getResidentaddresscode() == null : this.getResidentaddresscode().equals(other.getResidentaddresscode()))
            && (this.getBelongprovince() == null ? other.getBelongprovince() == null : this.getBelongprovince().equals(other.getBelongprovince()))
            && (this.getIsspecialzone() == null ? other.getIsspecialzone() == null : this.getIsspecialzone().equals(other.getIsspecialzone()))
            && (this.getSignintime() == null ? other.getSignintime() == null : this.getSignintime().equals(other.getSignintime()))
            && (this.getSignintype() == null ? other.getSignintype() == null : this.getSignintype().equals(other.getSignintype()))
            && (this.getSigninaddress() == null ? other.getSigninaddress() == null : this.getSigninaddress().equals(other.getSigninaddress()))
            && (this.getDeviceid() == null ? other.getDeviceid() == null : this.getDeviceid().equals(other.getDeviceid()))
            && (this.getSigninresidentaddress() == null ? other.getSigninresidentaddress() == null : this.getSigninresidentaddress().equals(other.getSigninresidentaddress()))
            && (this.getSigninaddresstype() == null ? other.getSigninaddresstype() == null : this.getSigninaddresstype().equals(other.getSigninaddresstype()))
            && (this.getResidentaddressname() == null ? other.getResidentaddressname() == null : this.getResidentaddressname().equals(other.getResidentaddressname()))
            && (this.getBelongtoorgname() == null ? other.getBelongtoorgname() == null : this.getBelongtoorgname().equals(other.getBelongtoorgname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSigninmonth() == null) ? 0 : getSigninmonth().hashCode());
        result = prime * result + ((getSignindate() == null) ? 0 : getSignindate().hashCode());
        result = prime * result + ((getDaytype() == null) ? 0 : getDaytype().hashCode());
        result = prime * result + ((getDaytypename() == null) ? 0 : getDaytypename().hashCode());
        result = prime * result + ((getUsercode() == null) ? 0 : getUsercode().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getWorkno() == null) ? 0 : getWorkno().hashCode());
        result = prime * result + ((getOrgcode() == null) ? 0 : getOrgcode().hashCode());
        result = prime * result + ((getOrgname() == null) ? 0 : getOrgname().hashCode());
        result = prime * result + ((getPositionlevel() == null) ? 0 : getPositionlevel().hashCode());
        result = prime * result + ((getResidentaddresscode() == null) ? 0 : getResidentaddresscode().hashCode());
        result = prime * result + ((getBelongprovince() == null) ? 0 : getBelongprovince().hashCode());
        result = prime * result + ((getIsspecialzone() == null) ? 0 : getIsspecialzone().hashCode());
        result = prime * result + ((getSignintime() == null) ? 0 : getSignintime().hashCode());
        result = prime * result + ((getSignintype() == null) ? 0 : getSignintype().hashCode());
        result = prime * result + ((getSigninaddress() == null) ? 0 : getSigninaddress().hashCode());
        result = prime * result + ((getDeviceid() == null) ? 0 : getDeviceid().hashCode());
        result = prime * result + ((getSigninresidentaddress() == null) ? 0 : getSigninresidentaddress().hashCode());
        result = prime * result + ((getSigninaddresstype() == null) ? 0 : getSigninaddresstype().hashCode());
        result = prime * result + ((getResidentaddressname() == null) ? 0 : getResidentaddressname().hashCode());
        result = prime * result + ((getBelongtoorgname() == null) ? 0 : getBelongtoorgname().hashCode());
        return result;
    }
}