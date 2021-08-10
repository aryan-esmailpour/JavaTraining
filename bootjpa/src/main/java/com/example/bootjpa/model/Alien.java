package com.example.bootjpa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;




//@Table(name = "studenttable")
@Entity
public class Alien {
    @Id
    private int aid;
    private String aname;
    private String course;
    private int agrade;

    @ManyToOne
    private School school;

    @JsonBackReference
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public int getAgrade() {
        return agrade;
    }

    public void setAgrade(int agrade) {
        this.agrade = agrade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }
}
