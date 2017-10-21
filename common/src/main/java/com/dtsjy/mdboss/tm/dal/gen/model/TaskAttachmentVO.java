package com.dtsjy.mdboss.tm.dal.gen.model;

import java.io.Serializable;
import java.util.Date;

public class TaskAttachmentVO implements Serializable {
    private Integer id;

    private String logcdoe;

    private String filecode;

    private String filename;

    private String filetype;

    private Date createtime;

    private String creator;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogcdoe() {
        return logcdoe;
    }

    public void setLogcdoe(String logcdoe) {
        this.logcdoe = logcdoe == null ? null : logcdoe.trim();
    }

    public String getFilecode() {
        return filecode;
    }

    public void setFilecode(String filecode) {
        this.filecode = filecode == null ? null : filecode.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", logcdoe=").append(logcdoe);
        sb.append(", filecode=").append(filecode);
        sb.append(", filename=").append(filename);
        sb.append(", filetype=").append(filetype);
        sb.append(", createtime=").append(createtime);
        sb.append(", creator=").append(creator);
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
        TaskAttachmentVO other = (TaskAttachmentVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLogcdoe() == null ? other.getLogcdoe() == null : this.getLogcdoe().equals(other.getLogcdoe()))
            && (this.getFilecode() == null ? other.getFilecode() == null : this.getFilecode().equals(other.getFilecode()))
            && (this.getFilename() == null ? other.getFilename() == null : this.getFilename().equals(other.getFilename()))
            && (this.getFiletype() == null ? other.getFiletype() == null : this.getFiletype().equals(other.getFiletype()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLogcdoe() == null) ? 0 : getLogcdoe().hashCode());
        result = prime * result + ((getFilecode() == null) ? 0 : getFilecode().hashCode());
        result = prime * result + ((getFilename() == null) ? 0 : getFilename().hashCode());
        result = prime * result + ((getFiletype() == null) ? 0 : getFiletype().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        return result;
    }
}