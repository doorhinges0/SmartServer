package com.sunrise.oa.dal.gen.model;

import java.io.Serializable;
import java.util.Date;

public class SealsVO implements Serializable {
    private Integer id;

    private String sealname;

    private String sealtype;

    private Integer deptid;

    private String deptname;

    private Integer signerid;

    private String signername;

    private Date createtime;

    private Date updatetime;

    private String status;

    private String description;

    private String authtype;

    private String certserialnum;

    private String issueto;

    private String issueby;

    private Date validfrom;

    private Date validto;

    private String sealimagetype;

    private String vcode;

    private String filecode;

    private String cachetcode;

    private String certpkcs7;

    private byte[] sealimage;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSealname() {
        return sealname;
    }

    public void setSealname(String sealname) {
        this.sealname = sealname == null ? null : sealname.trim();
    }

    public String getSealtype() {
        return sealtype;
    }

    public void setSealtype(String sealtype) {
        this.sealtype = sealtype == null ? null : sealtype.trim();
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public Integer getSignerid() {
        return signerid;
    }

    public void setSignerid(Integer signerid) {
        this.signerid = signerid;
    }

    public String getSignername() {
        return signername;
    }

    public void setSignername(String signername) {
        this.signername = signername == null ? null : signername.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getAuthtype() {
        return authtype;
    }

    public void setAuthtype(String authtype) {
        this.authtype = authtype == null ? null : authtype.trim();
    }

    public String getCertserialnum() {
        return certserialnum;
    }

    public void setCertserialnum(String certserialnum) {
        this.certserialnum = certserialnum == null ? null : certserialnum.trim();
    }

    public String getIssueto() {
        return issueto;
    }

    public void setIssueto(String issueto) {
        this.issueto = issueto == null ? null : issueto.trim();
    }

    public String getIssueby() {
        return issueby;
    }

    public void setIssueby(String issueby) {
        this.issueby = issueby == null ? null : issueby.trim();
    }

    public Date getValidfrom() {
        return validfrom;
    }

    public void setValidfrom(Date validfrom) {
        this.validfrom = validfrom;
    }

    public Date getValidto() {
        return validto;
    }

    public void setValidto(Date validto) {
        this.validto = validto;
    }

    public String getSealimagetype() {
        return sealimagetype;
    }

    public void setSealimagetype(String sealimagetype) {
        this.sealimagetype = sealimagetype == null ? null : sealimagetype.trim();
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode == null ? null : vcode.trim();
    }

    public String getFilecode() {
        return filecode;
    }

    public void setFilecode(String filecode) {
        this.filecode = filecode == null ? null : filecode.trim();
    }

    public String getCachetcode() {
        return cachetcode;
    }

    public void setCachetcode(String cachetcode) {
        this.cachetcode = cachetcode == null ? null : cachetcode.trim();
    }

    public String getCertpkcs7() {
        return certpkcs7;
    }

    public void setCertpkcs7(String certpkcs7) {
        this.certpkcs7 = certpkcs7 == null ? null : certpkcs7.trim();
    }

    public byte[] getSealimage() {
        return sealimage;
    }

    public void setSealimage(byte[] sealimage) {
        this.sealimage = sealimage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sealname=").append(sealname);
        sb.append(", sealtype=").append(sealtype);
        sb.append(", deptid=").append(deptid);
        sb.append(", deptname=").append(deptname);
        sb.append(", signerid=").append(signerid);
        sb.append(", signername=").append(signername);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", status=").append(status);
        sb.append(", description=").append(description);
        sb.append(", authtype=").append(authtype);
        sb.append(", certserialnum=").append(certserialnum);
        sb.append(", issueto=").append(issueto);
        sb.append(", issueby=").append(issueby);
        sb.append(", validfrom=").append(validfrom);
        sb.append(", validto=").append(validto);
        sb.append(", sealimagetype=").append(sealimagetype);
        sb.append(", vcode=").append(vcode);
        sb.append(", filecode=").append(filecode);
        sb.append(", cachetcode=").append(cachetcode);
        sb.append(", certpkcs7=").append(certpkcs7);
        sb.append(", sealimage=").append(sealimage);
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
        SealsVO other = (SealsVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSealname() == null ? other.getSealname() == null : this.getSealname().equals(other.getSealname()))
            && (this.getSealtype() == null ? other.getSealtype() == null : this.getSealtype().equals(other.getSealtype()))
            && (this.getDeptid() == null ? other.getDeptid() == null : this.getDeptid().equals(other.getDeptid()))
            && (this.getDeptname() == null ? other.getDeptname() == null : this.getDeptname().equals(other.getDeptname()))
            && (this.getSignerid() == null ? other.getSignerid() == null : this.getSignerid().equals(other.getSignerid()))
            && (this.getSignername() == null ? other.getSignername() == null : this.getSignername().equals(other.getSignername()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getAuthtype() == null ? other.getAuthtype() == null : this.getAuthtype().equals(other.getAuthtype()))
            && (this.getCertserialnum() == null ? other.getCertserialnum() == null : this.getCertserialnum().equals(other.getCertserialnum()))
            && (this.getIssueto() == null ? other.getIssueto() == null : this.getIssueto().equals(other.getIssueto()))
            && (this.getIssueby() == null ? other.getIssueby() == null : this.getIssueby().equals(other.getIssueby()))
            && (this.getValidfrom() == null ? other.getValidfrom() == null : this.getValidfrom().equals(other.getValidfrom()))
            && (this.getValidto() == null ? other.getValidto() == null : this.getValidto().equals(other.getValidto()))
            && (this.getSealimagetype() == null ? other.getSealimagetype() == null : this.getSealimagetype().equals(other.getSealimagetype()))
            && (this.getVcode() == null ? other.getVcode() == null : this.getVcode().equals(other.getVcode()))
            && (this.getFilecode() == null ? other.getFilecode() == null : this.getFilecode().equals(other.getFilecode()))
            && (this.getCachetcode() == null ? other.getCachetcode() == null : this.getCachetcode().equals(other.getCachetcode()))
            && (this.getCertpkcs7() == null ? other.getCertpkcs7() == null : this.getCertpkcs7().equals(other.getCertpkcs7()))
            && (this.getSealimage() == null ? other.getSealimage() == null : this.getSealimage().equals(other.getSealimage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSealname() == null) ? 0 : getSealname().hashCode());
        result = prime * result + ((getSealtype() == null) ? 0 : getSealtype().hashCode());
        result = prime * result + ((getDeptid() == null) ? 0 : getDeptid().hashCode());
        result = prime * result + ((getDeptname() == null) ? 0 : getDeptname().hashCode());
        result = prime * result + ((getSignerid() == null) ? 0 : getSignerid().hashCode());
        result = prime * result + ((getSignername() == null) ? 0 : getSignername().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getAuthtype() == null) ? 0 : getAuthtype().hashCode());
        result = prime * result + ((getCertserialnum() == null) ? 0 : getCertserialnum().hashCode());
        result = prime * result + ((getIssueto() == null) ? 0 : getIssueto().hashCode());
        result = prime * result + ((getIssueby() == null) ? 0 : getIssueby().hashCode());
        result = prime * result + ((getValidfrom() == null) ? 0 : getValidfrom().hashCode());
        result = prime * result + ((getValidto() == null) ? 0 : getValidto().hashCode());
        result = prime * result + ((getSealimagetype() == null) ? 0 : getSealimagetype().hashCode());
        result = prime * result + ((getVcode() == null) ? 0 : getVcode().hashCode());
        result = prime * result + ((getFilecode() == null) ? 0 : getFilecode().hashCode());
        result = prime * result + ((getCachetcode() == null) ? 0 : getCachetcode().hashCode());
        result = prime * result + ((getCertpkcs7() == null) ? 0 : getCertpkcs7().hashCode());
        result = prime * result + ((getSealimage() == null) ? 0 : getSealimage().hashCode());
        return result;
    }
}