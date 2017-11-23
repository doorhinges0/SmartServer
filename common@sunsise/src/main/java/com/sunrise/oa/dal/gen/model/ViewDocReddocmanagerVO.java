package com.sunrise.oa.dal.gen.model;

import java.io.Serializable;
import java.util.Date;

public class ViewDocReddocmanagerVO implements Serializable {
    private Integer id;

    private String reddocname;

    private String reddoctype;

    private String reddoctypename;

    private String filecode;

    private String creator;

    private String creatorname;

    private Date createtime;

    private String isenabled;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReddocname() {
        return reddocname;
    }

    public void setReddocname(String reddocname) {
        this.reddocname = reddocname == null ? null : reddocname.trim();
    }

    public String getReddoctype() {
        return reddoctype;
    }

    public void setReddoctype(String reddoctype) {
        this.reddoctype = reddoctype == null ? null : reddoctype.trim();
    }

    public String getReddoctypename() {
        return reddoctypename;
    }

    public void setReddoctypename(String reddoctypename) {
        this.reddoctypename = reddoctypename == null ? null : reddoctypename.trim();
    }

    public String getFilecode() {
        return filecode;
    }

    public void setFilecode(String filecode) {
        this.filecode = filecode == null ? null : filecode.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getCreatorname() {
        return creatorname;
    }

    public void setCreatorname(String creatorname) {
        this.creatorname = creatorname == null ? null : creatorname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getIsenabled() {
        return isenabled;
    }

    public void setIsenabled(String isenabled) {
        this.isenabled = isenabled == null ? null : isenabled.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", reddocname=").append(reddocname);
        sb.append(", reddoctype=").append(reddoctype);
        sb.append(", reddoctypename=").append(reddoctypename);
        sb.append(", filecode=").append(filecode);
        sb.append(", creator=").append(creator);
        sb.append(", creatorname=").append(creatorname);
        sb.append(", createtime=").append(createtime);
        sb.append(", isenabled=").append(isenabled);
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
        ViewDocReddocmanagerVO other = (ViewDocReddocmanagerVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getReddocname() == null ? other.getReddocname() == null : this.getReddocname().equals(other.getReddocname()))
            && (this.getReddoctype() == null ? other.getReddoctype() == null : this.getReddoctype().equals(other.getReddoctype()))
            && (this.getReddoctypename() == null ? other.getReddoctypename() == null : this.getReddoctypename().equals(other.getReddoctypename()))
            && (this.getFilecode() == null ? other.getFilecode() == null : this.getFilecode().equals(other.getFilecode()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatorname() == null ? other.getCreatorname() == null : this.getCreatorname().equals(other.getCreatorname()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getIsenabled() == null ? other.getIsenabled() == null : this.getIsenabled().equals(other.getIsenabled()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getReddocname() == null) ? 0 : getReddocname().hashCode());
        result = prime * result + ((getReddoctype() == null) ? 0 : getReddoctype().hashCode());
        result = prime * result + ((getReddoctypename() == null) ? 0 : getReddoctypename().hashCode());
        result = prime * result + ((getFilecode() == null) ? 0 : getFilecode().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatorname() == null) ? 0 : getCreatorname().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getIsenabled() == null) ? 0 : getIsenabled().hashCode());
        return result;
    }
}