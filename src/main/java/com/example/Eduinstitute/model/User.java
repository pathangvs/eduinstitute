package com.example.Eduinstitute.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    Long uid;
    String uname;
    String unumber;
    @Id
    String uemail;
    String upassword;

    public User(Long uid, String uname, String unumber, String uemail, String upassword ) {
        this.uid = uid;
        this.uname = uname;
        this.unumber = unumber;
        this.uemail = uemail;
        this.upassword = upassword;

    }

    public User() {

    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUnumber() {
        return unumber;
    }

    public void setUnumber(String unumber) {
        this.unumber = unumber;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

//    public String toString(){
//        return "user{"+"uid="+uid+",uname="+uname+",unumber="+unumber+",uemail="+uemail+",upassword="+upassword+"}";
//    }
}
