package com.example.bootjpa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//@Table(name = "schooltable")
@Entity
public class School {
    @Id
    private int sid;
    private String sname;

    @OneToMany
    private List<Alien> students = new ArrayList<Alien>();

    @JsonManagedReference
    public List<Alien> getStudents() {
        return students;
    }

    public void setStudents(List<Alien> students) {
        this.students = students;
    }

    public void addToStudents(Alien student)
    {
        this.students.add(student);
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
