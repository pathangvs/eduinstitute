package com.example.Eduinstitute.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    @Id
    Long cid;
    String coname;
    String cduration;
    String csdate;
    String cbrief;
    String cdetail;
    String cflag;

    public Course(Long cid, String coname, String cduration, String csdate, String cbrief,String cdetail,String cflag) {
        this.cid = cid;
        this.coname = coname;
        this.cduration = cduration;
        this.csdate = csdate;
        this.cbrief=cbrief;
        this.cdetail=cdetail;
        this.cflag=cflag;
    }

    public Course() {

    }

    public Course(String cflag) {
        this.cflag = cflag;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }


    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }

    public String getCduration() {
        return cduration;
    }

    public void setCduration(String cduration) {
        this.cduration = cduration;
    }

    public String getCsdate() {
        return csdate;
    }

    public void setCsdate(String csdate) {
        this.csdate = csdate;
    }

    public String getCbrief() {
        return cbrief;
    }

    public void setCbrief(String cbrief) {
        this.cbrief = cbrief;
    }

    public String getCdetail() {
        return cdetail;
    }

    public void setCdetail(String cdetail) {
        this.cdetail = cdetail;
    }

    public String getCflag() {
        return cflag;
    }

    public void setCflag(String cflag) {
        this.cflag = cflag;
    }

    //    public String toString(){
//        return "courses{"+"cid="+cid+",cname="+cname+",cduration="+cduration+",csdate="+csdate+"}";
//    }


}
