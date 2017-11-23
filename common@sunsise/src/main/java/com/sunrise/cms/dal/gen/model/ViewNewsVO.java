package com.sunrise.cms.dal.gen.model;

import java.io.Serializable;
import java.util.Date;

public class ViewNewsVO implements Serializable {
    private Integer id;

    private String newscode;

    private String title;

    private String newstype;

    private String newstypename;

    private String status;

    private String statusname;

    private String source;

    private String publisher;

    private String publishername;

    private Date publishtime;

    private String creator;

    private String creatorname;

    private Date createtime;

    private String img;

    private String attachment;

    private Boolean showimg;

    private String topshow;

    private String newsurl;

    private String author;

    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewscode() {
        return newscode;
    }

    public void setNewscode(String newscode) {
        this.newscode = newscode == null ? null : newscode.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getNewstype() {
        return newstype;
    }

    public void setNewstype(String newstype) {
        this.newstype = newstype == null ? null : newstype.trim();
    }

    public String getNewstypename() {
        return newstypename;
    }

    public void setNewstypename(String newstypename) {
        this.newstypename = newstypename == null ? null : newstypename.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname == null ? null : statusname.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getPublishername() {
        return publishername;
    }

    public void setPublishername(String publishername) {
        this.publishername = publishername == null ? null : publishername.trim();
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public Boolean getShowimg() {
        return showimg;
    }

    public void setShowimg(Boolean showimg) {
        this.showimg = showimg;
    }

    public String getTopshow() {
        return topshow;
    }

    public void setTopshow(String topshow) {
        this.topshow = topshow == null ? null : topshow.trim();
    }

    public String getNewsurl() {
        return newsurl;
    }

    public void setNewsurl(String newsurl) {
        this.newsurl = newsurl == null ? null : newsurl.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", newscode=").append(newscode);
        sb.append(", title=").append(title);
        sb.append(", newstype=").append(newstype);
        sb.append(", newstypename=").append(newstypename);
        sb.append(", status=").append(status);
        sb.append(", statusname=").append(statusname);
        sb.append(", source=").append(source);
        sb.append(", publisher=").append(publisher);
        sb.append(", publishername=").append(publishername);
        sb.append(", publishtime=").append(publishtime);
        sb.append(", creator=").append(creator);
        sb.append(", creatorname=").append(creatorname);
        sb.append(", createtime=").append(createtime);
        sb.append(", img=").append(img);
        sb.append(", attachment=").append(attachment);
        sb.append(", showimg=").append(showimg);
        sb.append(", topshow=").append(topshow);
        sb.append(", newsurl=").append(newsurl);
        sb.append(", author=").append(author);
        sb.append(", content=").append(content);
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
        ViewNewsVO other = (ViewNewsVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNewscode() == null ? other.getNewscode() == null : this.getNewscode().equals(other.getNewscode()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getNewstype() == null ? other.getNewstype() == null : this.getNewstype().equals(other.getNewstype()))
            && (this.getNewstypename() == null ? other.getNewstypename() == null : this.getNewstypename().equals(other.getNewstypename()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getStatusname() == null ? other.getStatusname() == null : this.getStatusname().equals(other.getStatusname()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getPublisher() == null ? other.getPublisher() == null : this.getPublisher().equals(other.getPublisher()))
            && (this.getPublishername() == null ? other.getPublishername() == null : this.getPublishername().equals(other.getPublishername()))
            && (this.getPublishtime() == null ? other.getPublishtime() == null : this.getPublishtime().equals(other.getPublishtime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatorname() == null ? other.getCreatorname() == null : this.getCreatorname().equals(other.getCreatorname()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getAttachment() == null ? other.getAttachment() == null : this.getAttachment().equals(other.getAttachment()))
            && (this.getShowimg() == null ? other.getShowimg() == null : this.getShowimg().equals(other.getShowimg()))
            && (this.getTopshow() == null ? other.getTopshow() == null : this.getTopshow().equals(other.getTopshow()))
            && (this.getNewsurl() == null ? other.getNewsurl() == null : this.getNewsurl().equals(other.getNewsurl()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNewscode() == null) ? 0 : getNewscode().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getNewstype() == null) ? 0 : getNewstype().hashCode());
        result = prime * result + ((getNewstypename() == null) ? 0 : getNewstypename().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getStatusname() == null) ? 0 : getStatusname().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getPublisher() == null) ? 0 : getPublisher().hashCode());
        result = prime * result + ((getPublishername() == null) ? 0 : getPublishername().hashCode());
        result = prime * result + ((getPublishtime() == null) ? 0 : getPublishtime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatorname() == null) ? 0 : getCreatorname().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getAttachment() == null) ? 0 : getAttachment().hashCode());
        result = prime * result + ((getShowimg() == null) ? 0 : getShowimg().hashCode());
        result = prime * result + ((getTopshow() == null) ? 0 : getTopshow().hashCode());
        result = prime * result + ((getNewsurl() == null) ? 0 : getNewsurl().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }
}