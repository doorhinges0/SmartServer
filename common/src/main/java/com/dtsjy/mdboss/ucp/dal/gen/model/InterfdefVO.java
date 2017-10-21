package com.dtsjy.mdboss.ucp.dal.gen.model;

import java.io.Serializable;

public class InterfdefVO implements Serializable {
    private Integer id;

    private String appcode;

    private String interfname;

    private String interfclass;

    private String methodname;

    private Boolean saveservlog;

    private Boolean saveexceptionlog;

    private Boolean saveservoutput;

    private Boolean saveservinput;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppcode() {
        return appcode;
    }

    public void setAppcode(String appcode) {
        this.appcode = appcode == null ? null : appcode.trim();
    }

    public String getInterfname() {
        return interfname;
    }

    public void setInterfname(String interfname) {
        this.interfname = interfname == null ? null : interfname.trim();
    }

    public String getInterfclass() {
        return interfclass;
    }

    public void setInterfclass(String interfclass) {
        this.interfclass = interfclass == null ? null : interfclass.trim();
    }

    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname == null ? null : methodname.trim();
    }

    public Boolean getSaveservlog() {
        return saveservlog;
    }

    public void setSaveservlog(Boolean saveservlog) {
        this.saveservlog = saveservlog;
    }

    public Boolean getSaveexceptionlog() {
        return saveexceptionlog;
    }

    public void setSaveexceptionlog(Boolean saveexceptionlog) {
        this.saveexceptionlog = saveexceptionlog;
    }

    public Boolean getSaveservoutput() {
        return saveservoutput;
    }

    public void setSaveservoutput(Boolean saveservoutput) {
        this.saveservoutput = saveservoutput;
    }

    public Boolean getSaveservinput() {
        return saveservinput;
    }

    public void setSaveservinput(Boolean saveservinput) {
        this.saveservinput = saveservinput;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appcode=").append(appcode);
        sb.append(", interfname=").append(interfname);
        sb.append(", interfclass=").append(interfclass);
        sb.append(", methodname=").append(methodname);
        sb.append(", saveservlog=").append(saveservlog);
        sb.append(", saveexceptionlog=").append(saveexceptionlog);
        sb.append(", saveservoutput=").append(saveservoutput);
        sb.append(", saveservinput=").append(saveservinput);
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
        InterfdefVO other = (InterfdefVO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppcode() == null ? other.getAppcode() == null : this.getAppcode().equals(other.getAppcode()))
            && (this.getInterfname() == null ? other.getInterfname() == null : this.getInterfname().equals(other.getInterfname()))
            && (this.getInterfclass() == null ? other.getInterfclass() == null : this.getInterfclass().equals(other.getInterfclass()))
            && (this.getMethodname() == null ? other.getMethodname() == null : this.getMethodname().equals(other.getMethodname()))
            && (this.getSaveservlog() == null ? other.getSaveservlog() == null : this.getSaveservlog().equals(other.getSaveservlog()))
            && (this.getSaveexceptionlog() == null ? other.getSaveexceptionlog() == null : this.getSaveexceptionlog().equals(other.getSaveexceptionlog()))
            && (this.getSaveservoutput() == null ? other.getSaveservoutput() == null : this.getSaveservoutput().equals(other.getSaveservoutput()))
            && (this.getSaveservinput() == null ? other.getSaveservinput() == null : this.getSaveservinput().equals(other.getSaveservinput()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppcode() == null) ? 0 : getAppcode().hashCode());
        result = prime * result + ((getInterfname() == null) ? 0 : getInterfname().hashCode());
        result = prime * result + ((getInterfclass() == null) ? 0 : getInterfclass().hashCode());
        result = prime * result + ((getMethodname() == null) ? 0 : getMethodname().hashCode());
        result = prime * result + ((getSaveservlog() == null) ? 0 : getSaveservlog().hashCode());
        result = prime * result + ((getSaveexceptionlog() == null) ? 0 : getSaveexceptionlog().hashCode());
        result = prime * result + ((getSaveservoutput() == null) ? 0 : getSaveservoutput().hashCode());
        result = prime * result + ((getSaveservinput() == null) ? 0 : getSaveservinput().hashCode());
        return result;
    }
}