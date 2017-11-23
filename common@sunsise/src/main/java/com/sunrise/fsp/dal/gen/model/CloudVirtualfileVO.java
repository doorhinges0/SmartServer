package com.sunrise.fsp.dal.gen.model;

import java.io.Serializable;
import java.util.Date;

public class CloudVirtualfileVO implements Serializable {
    private Integer id;

    private String filecode;

    private String filename;

    private String fileid;

    private String foldercode;

    private String filesuffix;

    private String filetype;

    private Integer size;

    private String creator;

    private Date createtime;

    private String updator;

    private Date updatetime;

    private String filedesc;

    private String downloadurl;

    private String previewurl;

    private String versioninfo;

    private Boolean hasqrcode;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid == null ? null : fileid.trim();
    }

    public String getFoldercode() {
        return foldercode;
    }

    public void setFoldercode(String foldercode) {
        this.foldercode = foldercode == null ? null : foldercode.trim();
    }

    public String getFilesuffix() {
        return filesuffix;
    }

    public void setFilesuffix(String filesuffix) {
        this.filesuffix = filesuffix == null ? null : filesuffix.trim();
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator == null ? null : updator.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getFiledesc() {
        return filedesc;
    }

    public void setFiledesc(String filedesc) {
        this.filedesc = filedesc == null ? null : filedesc.trim();
    }

    public String getDownloadurl() {
        return downloadurl;
    }

    public void setDownloadurl(String downloadurl) {
        this.downloadurl = downloadurl == null ? null : downloadurl.trim();
    }

    public String getPreviewurl() {
        return previewurl;
    }

    public void setPreviewurl(String previewurl) {
        this.previewurl = previewurl == null ? null : previewurl.trim();
    }

    public String getVersioninfo() {
        return versioninfo;
    }

    public void setVersioninfo(String versioninfo) {
        this.versioninfo = versioninfo == null ? null : versioninfo.trim();
    }

    public Boolean getHasqrcode() {
        return hasqrcode;
    }

    public void setHasqrcode(Boolean hasqrcode) {
        this.hasqrcode = hasqrcode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", filecode=").append(filecode);
        sb.append(", filename=").append(filename);
        sb.append(", fileid=").append(fileid);
        sb.append(", foldercode=").append(foldercode);
        sb.append(", filesuffix=").append(filesuffix);
        sb.append(", filetype=").append(filetype);
        sb.append(", size=").append(size);
        sb.append(", creator=").append(creator);
        sb.append(", createtime=").append(createtime);
        sb.append(", updator=").append(updator);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", filedesc=").append(filedesc);
        sb.append(", downloadurl=").append(downloadurl);
        sb.append(", previewurl=").append(previewurl);
        sb.append(", versioninfo=").append(versioninfo);
        sb.append(", hasqrcode=").append(hasqrcode);
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
        CloudVirtualfileVO other = (CloudVirtualfileVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFilecode() == null ? other.getFilecode() == null : this.getFilecode().equals(other.getFilecode()))
            && (this.getFilename() == null ? other.getFilename() == null : this.getFilename().equals(other.getFilename()))
            && (this.getFileid() == null ? other.getFileid() == null : this.getFileid().equals(other.getFileid()))
            && (this.getFoldercode() == null ? other.getFoldercode() == null : this.getFoldercode().equals(other.getFoldercode()))
            && (this.getFilesuffix() == null ? other.getFilesuffix() == null : this.getFilesuffix().equals(other.getFilesuffix()))
            && (this.getFiletype() == null ? other.getFiletype() == null : this.getFiletype().equals(other.getFiletype()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdator() == null ? other.getUpdator() == null : this.getUpdator().equals(other.getUpdator()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getFiledesc() == null ? other.getFiledesc() == null : this.getFiledesc().equals(other.getFiledesc()))
            && (this.getDownloadurl() == null ? other.getDownloadurl() == null : this.getDownloadurl().equals(other.getDownloadurl()))
            && (this.getPreviewurl() == null ? other.getPreviewurl() == null : this.getPreviewurl().equals(other.getPreviewurl()))
            && (this.getVersioninfo() == null ? other.getVersioninfo() == null : this.getVersioninfo().equals(other.getVersioninfo()))
            && (this.getHasqrcode() == null ? other.getHasqrcode() == null : this.getHasqrcode().equals(other.getHasqrcode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFilecode() == null) ? 0 : getFilecode().hashCode());
        result = prime * result + ((getFilename() == null) ? 0 : getFilename().hashCode());
        result = prime * result + ((getFileid() == null) ? 0 : getFileid().hashCode());
        result = prime * result + ((getFoldercode() == null) ? 0 : getFoldercode().hashCode());
        result = prime * result + ((getFilesuffix() == null) ? 0 : getFilesuffix().hashCode());
        result = prime * result + ((getFiletype() == null) ? 0 : getFiletype().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdator() == null) ? 0 : getUpdator().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getFiledesc() == null) ? 0 : getFiledesc().hashCode());
        result = prime * result + ((getDownloadurl() == null) ? 0 : getDownloadurl().hashCode());
        result = prime * result + ((getPreviewurl() == null) ? 0 : getPreviewurl().hashCode());
        result = prime * result + ((getVersioninfo() == null) ? 0 : getVersioninfo().hashCode());
        result = prime * result + ((getHasqrcode() == null) ? 0 : getHasqrcode().hashCode());
        return result;
    }
}