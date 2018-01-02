package com.rfc.spider.entity;

import jdk.nashorn.internal.ir.IdentNode;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by Administrator on 2017/6/24.
 */
public class DomesticDataEntity {

//    domestic|Monday003|1|0|2.95|3.05|2.19| domestic|Monday003|2|+1|1.52|3.75|4.90

    public String		seqtime;
    public String		company;
    public Integer		handicap;
    public Integer     biztype;
    public String      team;
    public Long         batchno;
//    public Double	    w0ratio;
//    public Double	    d0ratio;
//    public Double	    l0ratio;
    public Double	    wratio;
    public Double	    dratio;
    public Double	    lratio;

    public Double	    ratio1;
    public Double	    ratio2;
    public String      cahandicap;
    public String      subcompany;

    public String getSubcompany() {
        return subcompany;
    }

    public void setSubcompany(String subcompany) {
        this.subcompany = subcompany;
    }

    public Double getRatio1() {
        return ratio1;
    }

    public void setRatio1(Double ratio1) {
        this.ratio1 = ratio1;
    }

    public Double getRatio2() {
        return ratio2;
    }

    public void setRatio2(Double ratio2) {
        this.ratio2 = ratio2;
    }

    public String getCahandicap() {
        return cahandicap;
    }

    public void setCahandicap(String cahandicap) {
        this.cahandicap = cahandicap;
    }

    public Long getBatchno() {
        return batchno;
    }

    public void setBatchno(Long batchno) {
        this.batchno = batchno;
    }

    public String getSeqtime() {
        return seqtime;
    }

    public void setSeqtime(String seqtime) {
        this.seqtime = seqtime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getHandicap() {
        return handicap;
    }

    public void setHandicap(Integer handicap) {
        this.handicap = handicap;
    }

    public Integer getBiztype() {
        return biztype;
    }

    public void setBiztype(Integer biztype) {
        this.biztype = biztype;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Double getWratio() {
        return wratio;
    }

    public void setWratio(Double wratio) {
        this.wratio = wratio;
    }

    public Double getDratio() {
        return dratio;
    }

    public void setDratio(Double dratio) {
        this.dratio = dratio;
    }

    public Double getLratio() {
        return lratio;
    }

    public void setLratio(Double lratio) {
        this.lratio = lratio;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
