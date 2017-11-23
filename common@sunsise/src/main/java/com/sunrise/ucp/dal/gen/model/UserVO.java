package com.sunrise.ucp.dal.gen.model;

import java.io.Serializable;
import java.util.Date;

public class UserVO implements Serializable {
    private Integer id;

    private String usercode;

    private String username;

    private String password;

    private String orgcode;

    private String sex;

    private String userrank;

    private String userlevel;

    private String positionlevel;

    private String mobileno;

    private String officephone;

    private String email;

    private String imnumber;

    private String address;

    private Date updatetime;

    private String avatarcode;

    private String validatecode;

    private String ikeynumber;

    private String userdesc;

    private String leader;

    private String workno;

    private String pinyin;

    private String isenabled;

    private String signfilecode;

    private String extorgcode;

    private String residentaddresscode;

    private Date birthday;

    private String allowance;
    
    private String orgname;
    
    private String belongtoorgname;
    
    

    public String getBelongtoorgname() {
		return belongtoorgname;
	}

	public void setBelongtoorgname(String belongtoorgname) {
		this.belongtoorgname = belongtoorgname;
	}

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode == null ? null : orgcode.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getUserrank() {
        return userrank;
    }

    public void setUserrank(String userrank) {
        this.userrank = userrank == null ? null : userrank.trim();
    }

    public String getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(String userlevel) {
        this.userlevel = userlevel == null ? null : userlevel.trim();
    }

    public String getPositionlevel() {
        return positionlevel;
    }

    public void setPositionlevel(String positionlevel) {
        this.positionlevel = positionlevel == null ? null : positionlevel.trim();
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno == null ? null : mobileno.trim();
    }

    public String getOfficephone() {
        return officephone;
    }

    public void setOfficephone(String officephone) {
        this.officephone = officephone == null ? null : officephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getImnumber() {
        return imnumber;
    }

    public void setImnumber(String imnumber) {
        this.imnumber = imnumber == null ? null : imnumber.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getAvatarcode() {
        return avatarcode;
    }

    public void setAvatarcode(String avatarcode) {
        this.avatarcode = avatarcode == null ? null : avatarcode.trim();
    }

    public String getValidatecode() {
        return validatecode;
    }

    public void setValidatecode(String validatecode) {
        this.validatecode = validatecode == null ? null : validatecode.trim();
    }

    public String getIkeynumber() {
        return ikeynumber;
    }

    public void setIkeynumber(String ikeynumber) {
        this.ikeynumber = ikeynumber == null ? null : ikeynumber.trim();
    }

    public String getUserdesc() {
        return userdesc;
    }

    public void setUserdesc(String userdesc) {
        this.userdesc = userdesc == null ? null : userdesc.trim();
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader == null ? null : leader.trim();
    }

    public String getWorkno() {
        return workno;
    }

    public void setWorkno(String workno) {
        this.workno = workno == null ? null : workno.trim();
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }

    public String getIsenabled() {
        return isenabled;
    }

    public void setIsenabled(String isenabled) {
        this.isenabled = isenabled == null ? null : isenabled.trim();
    }

    public String getSignfilecode() {
        return signfilecode;
    }

    public void setSignfilecode(String signfilecode) {
        this.signfilecode = signfilecode == null ? null : signfilecode.trim();
    }

    public String getExtorgcode() {
        return extorgcode;
    }

    public void setExtorgcode(String extorgcode) {
        this.extorgcode = extorgcode == null ? null : extorgcode.trim();
    }

    public String getResidentaddresscode() {
        return residentaddresscode;
    }

    public void setResidentaddresscode(String residentaddresscode) {
        this.residentaddresscode = residentaddresscode == null ? null : residentaddresscode.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAllowance() {
        return allowance;
    }

    public void setAllowance(String allowance) {
        this.allowance = allowance == null ? null : allowance.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", usercode=").append(usercode);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", orgcode=").append(orgcode);
        sb.append(", sex=").append(sex);
        sb.append(", userrank=").append(userrank);
        sb.append(", userlevel=").append(userlevel);
        sb.append(", positionlevel=").append(positionlevel);
        sb.append(", mobileno=").append(mobileno);
        sb.append(", officephone=").append(officephone);
        sb.append(", email=").append(email);
        sb.append(", imnumber=").append(imnumber);
        sb.append(", address=").append(address);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", avatarcode=").append(avatarcode);
        sb.append(", validatecode=").append(validatecode);
        sb.append(", ikeynumber=").append(ikeynumber);
        sb.append(", userdesc=").append(userdesc);
        sb.append(", leader=").append(leader);
        sb.append(", workno=").append(workno);
        sb.append(", pinyin=").append(pinyin);
        sb.append(", isenabled=").append(isenabled);
        sb.append(", signfilecode=").append(signfilecode);
        sb.append(", extorgcode=").append(extorgcode);
        sb.append(", residentaddresscode=").append(residentaddresscode);
        sb.append(", birthday=").append(birthday);
        sb.append(", allowance=").append(allowance);
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
        UserVO other = (UserVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsercode() == null ? other.getUsercode() == null : this.getUsercode().equals(other.getUsercode()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getOrgcode() == null ? other.getOrgcode() == null : this.getOrgcode().equals(other.getOrgcode()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getUserrank() == null ? other.getUserrank() == null : this.getUserrank().equals(other.getUserrank()))
            && (this.getUserlevel() == null ? other.getUserlevel() == null : this.getUserlevel().equals(other.getUserlevel()))
            && (this.getPositionlevel() == null ? other.getPositionlevel() == null : this.getPositionlevel().equals(other.getPositionlevel()))
            && (this.getMobileno() == null ? other.getMobileno() == null : this.getMobileno().equals(other.getMobileno()))
            && (this.getOfficephone() == null ? other.getOfficephone() == null : this.getOfficephone().equals(other.getOfficephone()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getImnumber() == null ? other.getImnumber() == null : this.getImnumber().equals(other.getImnumber()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getAvatarcode() == null ? other.getAvatarcode() == null : this.getAvatarcode().equals(other.getAvatarcode()))
            && (this.getValidatecode() == null ? other.getValidatecode() == null : this.getValidatecode().equals(other.getValidatecode()))
            && (this.getIkeynumber() == null ? other.getIkeynumber() == null : this.getIkeynumber().equals(other.getIkeynumber()))
            && (this.getUserdesc() == null ? other.getUserdesc() == null : this.getUserdesc().equals(other.getUserdesc()))
            && (this.getLeader() == null ? other.getLeader() == null : this.getLeader().equals(other.getLeader()))
            && (this.getWorkno() == null ? other.getWorkno() == null : this.getWorkno().equals(other.getWorkno()))
            && (this.getPinyin() == null ? other.getPinyin() == null : this.getPinyin().equals(other.getPinyin()))
            && (this.getIsenabled() == null ? other.getIsenabled() == null : this.getIsenabled().equals(other.getIsenabled()))
            && (this.getSignfilecode() == null ? other.getSignfilecode() == null : this.getSignfilecode().equals(other.getSignfilecode()))
            && (this.getExtorgcode() == null ? other.getExtorgcode() == null : this.getExtorgcode().equals(other.getExtorgcode()))
            && (this.getResidentaddresscode() == null ? other.getResidentaddresscode() == null : this.getResidentaddresscode().equals(other.getResidentaddresscode()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getAllowance() == null ? other.getAllowance() == null : this.getAllowance().equals(other.getAllowance()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsercode() == null) ? 0 : getUsercode().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getOrgcode() == null) ? 0 : getOrgcode().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getUserrank() == null) ? 0 : getUserrank().hashCode());
        result = prime * result + ((getUserlevel() == null) ? 0 : getUserlevel().hashCode());
        result = prime * result + ((getPositionlevel() == null) ? 0 : getPositionlevel().hashCode());
        result = prime * result + ((getMobileno() == null) ? 0 : getMobileno().hashCode());
        result = prime * result + ((getOfficephone() == null) ? 0 : getOfficephone().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getImnumber() == null) ? 0 : getImnumber().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getAvatarcode() == null) ? 0 : getAvatarcode().hashCode());
        result = prime * result + ((getValidatecode() == null) ? 0 : getValidatecode().hashCode());
        result = prime * result + ((getIkeynumber() == null) ? 0 : getIkeynumber().hashCode());
        result = prime * result + ((getUserdesc() == null) ? 0 : getUserdesc().hashCode());
        result = prime * result + ((getLeader() == null) ? 0 : getLeader().hashCode());
        result = prime * result + ((getWorkno() == null) ? 0 : getWorkno().hashCode());
        result = prime * result + ((getPinyin() == null) ? 0 : getPinyin().hashCode());
        result = prime * result + ((getIsenabled() == null) ? 0 : getIsenabled().hashCode());
        result = prime * result + ((getSignfilecode() == null) ? 0 : getSignfilecode().hashCode());
        result = prime * result + ((getExtorgcode() == null) ? 0 : getExtorgcode().hashCode());
        result = prime * result + ((getResidentaddresscode() == null) ? 0 : getResidentaddresscode().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getAllowance() == null) ? 0 : getAllowance().hashCode());
        return result;
    }

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
}