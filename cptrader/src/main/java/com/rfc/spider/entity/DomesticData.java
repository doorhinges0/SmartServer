package com.rfc.spider.entity;

public class DomesticData {
    private Long batchno;

    private Integer biztype;

    private Integer handicap;

    private String company;

    private String subcompany;

    private String team;

    private String seqtime;

    private Double wratio;

    private Double dratio;

    private Double lratio;

    private Double ratio1;

    private Double ratio2;

    private String cahandicap;

    private String createdate;

    public Long getBatchno() {
        return batchno;
    }

    public void setBatchno(Long batchno) {
        this.batchno = batchno;
    }

    public Integer getBiztype() {
        return biztype;
    }

    public void setBiztype(Integer biztype) {
        this.biztype = biztype;
    }

    public Integer getHandicap() {
        return handicap;
    }

    public void setHandicap(Integer handicap) {
        this.handicap = handicap;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getSubcompany() {
        return subcompany;
    }

    public void setSubcompany(String subcompany) {
        this.subcompany = subcompany == null ? null : subcompany.trim();
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team == null ? null : team.trim();
    }

    public String getSeqtime() {
        return seqtime;
    }

    public void setSeqtime(String seqtime) {
        this.seqtime = seqtime == null ? null : seqtime.trim();
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
        this.cahandicap = cahandicap == null ? null : cahandicap.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }
}