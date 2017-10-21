package com.dtsjy.mdboss.ucp.dal.gen.model;

import java.io.Serializable;
import java.util.Date;

public class DictItemVO implements Serializable {
    private Integer id;

    private String dictcode;

    private String groupcode;

    private String dictname;

    private Byte dictorder;

    private String dictstate;

    private Date updatetime;

    private String dictdesc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictcode() {
        return dictcode;
    }

    public void setDictcode(String dictcode) {
        this.dictcode = dictcode == null ? null : dictcode.trim();
    }

    public String getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode == null ? null : groupcode.trim();
    }

    public String getDictname() {
        return dictname;
    }

    public void setDictname(String dictname) {
        this.dictname = dictname == null ? null : dictname.trim();
    }

    public Byte getDictorder() {
        return dictorder;
    }

    public void setDictorder(Byte dictorder) {
        this.dictorder = dictorder;
    }

    public String getDictstate() {
        return dictstate;
    }

    public void setDictstate(String dictstate) {
        this.dictstate = dictstate == null ? null : dictstate.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getDictdesc() {
        return dictdesc;
    }

    public void setDictdesc(String dictdesc) {
        this.dictdesc = dictdesc == null ? null : dictdesc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dictcode=").append(dictcode);
        sb.append(", groupcode=").append(groupcode);
        sb.append(", dictname=").append(dictname);
        sb.append(", dictorder=").append(dictorder);
        sb.append(", dictstate=").append(dictstate);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", dictdesc=").append(dictdesc);
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
        DictItemVO other = (DictItemVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDictcode() == null ? other.getDictcode() == null : this.getDictcode().equals(other.getDictcode()))
            && (this.getGroupcode() == null ? other.getGroupcode() == null : this.getGroupcode().equals(other.getGroupcode()))
            && (this.getDictname() == null ? other.getDictname() == null : this.getDictname().equals(other.getDictname()))
            && (this.getDictorder() == null ? other.getDictorder() == null : this.getDictorder().equals(other.getDictorder()))
            && (this.getDictstate() == null ? other.getDictstate() == null : this.getDictstate().equals(other.getDictstate()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getDictdesc() == null ? other.getDictdesc() == null : this.getDictdesc().equals(other.getDictdesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDictcode() == null) ? 0 : getDictcode().hashCode());
        result = prime * result + ((getGroupcode() == null) ? 0 : getGroupcode().hashCode());
        result = prime * result + ((getDictname() == null) ? 0 : getDictname().hashCode());
        result = prime * result + ((getDictorder() == null) ? 0 : getDictorder().hashCode());
        result = prime * result + ((getDictstate() == null) ? 0 : getDictstate().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getDictdesc() == null) ? 0 : getDictdesc().hashCode());
        return result;
    }
}