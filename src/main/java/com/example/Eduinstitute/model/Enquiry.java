package com.example.Eduinstitute.model;

import com.example.Eduinstitute.repositry.Enquiryrepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Eduinstitute.model.Course;

import javax.persistence.*;

@Entity
@Table(name = "enquiry")
public class Enquiry {


    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long eid;
    String ename;
    String equalification;
    String enumber;
    @Id
    String eemail;
    Long cid;

    public Enquiry(String ename, String equalification, String enumber, String eemail, Long cid) {
        this.ename = ename;
        this.equalification = equalification;
        this.enumber = enumber;
        this.eemail = eemail;
        this.cid = cid;
    }

    public Enquiry(){

    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEqualification() {
        return equalification;
    }

    public void setEqualification(String equalification) {
        this.equalification = equalification;
    }

    public String getEnumber() {
        return enumber;
    }

    public void setEnumber(String enumber) {
        this.enumber = enumber;
    }

    public String getEemail() {
        return eemail;
    }

    public void setEemail(String eemail) {
        this.eemail = eemail;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }
}


