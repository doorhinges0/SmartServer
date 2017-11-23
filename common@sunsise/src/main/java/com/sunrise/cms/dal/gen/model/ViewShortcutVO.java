package com.sunrise.cms.dal.gen.model;

import java.io.Serializable;
import java.util.Date;

public class ViewShortcutVO implements Serializable {
    private Integer id;

    private String shortcutcode;

    private String name;

    private String icon;

    private String linkd;

    private Boolean ishow;

    private Integer sortorder;

    private String owner;

    private String creator;

    private String creatorname;

    private Date createtime;

    private String usercode;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortcutcode() {
        return shortcutcode;
    }

    public void setShortcutcode(String shortcutcode) {
        this.shortcutcode = shortcutcode == null ? null : shortcutcode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getLinkd() {
        return linkd;
    }

    public void setLinkd(String linkd) {
        this.linkd = linkd == null ? null : linkd.trim();
    }

    public Boolean getIshow() {
        return ishow;
    }

    public void setIshow(Boolean ishow) {
        this.ishow = ishow;
    }

    public Integer getSortorder() {
        return sortorder;
    }

    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
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

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shortcutcode=").append(shortcutcode);
        sb.append(", name=").append(name);
        sb.append(", icon=").append(icon);
        sb.append(", linkd=").append(linkd);
        sb.append(", ishow=").append(ishow);
        sb.append(", sortorder=").append(sortorder);
        sb.append(", owner=").append(owner);
        sb.append(", creator=").append(creator);
        sb.append(", creatorname=").append(creatorname);
        sb.append(", createtime=").append(createtime);
        sb.append(", usercode=").append(usercode);
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
        ViewShortcutVO other = (ViewShortcutVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getShortcutcode() == null ? other.getShortcutcode() == null : this.getShortcutcode().equals(other.getShortcutcode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getLinkd() == null ? other.getLinkd() == null : this.getLinkd().equals(other.getLinkd()))
            && (this.getIshow() == null ? other.getIshow() == null : this.getIshow().equals(other.getIshow()))
            && (this.getSortorder() == null ? other.getSortorder() == null : this.getSortorder().equals(other.getSortorder()))
            && (this.getOwner() == null ? other.getOwner() == null : this.getOwner().equals(other.getOwner()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatorname() == null ? other.getCreatorname() == null : this.getCreatorname().equals(other.getCreatorname()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUsercode() == null ? other.getUsercode() == null : this.getUsercode().equals(other.getUsercode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getShortcutcode() == null) ? 0 : getShortcutcode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getLinkd() == null) ? 0 : getLinkd().hashCode());
        result = prime * result + ((getIshow() == null) ? 0 : getIshow().hashCode());
        result = prime * result + ((getSortorder() == null) ? 0 : getSortorder().hashCode());
        result = prime * result + ((getOwner() == null) ? 0 : getOwner().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatorname() == null) ? 0 : getCreatorname().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUsercode() == null) ? 0 : getUsercode().hashCode());
        return result;
    }
}