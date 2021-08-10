package com.example.bootjpa.controller;

import com.example.bootjpa.model.School;
import com.example.bootjpa.repos.SchoolRepo;
import com.example.bootjpa.repos.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class SchoolController {
    @Autowired
    SchoolRepo repo;

    @RequestMapping("/school")
    public ModelAndView home()
    {
        ModelAndView mv = new ModelAndView("school.html");
        return mv;
    }

    @RequestMapping("/addSchool")
    public School addSchool(School school)
    {
        repo.save(school);
        return school;
    }

    @RequestMapping("/deleteSchool")
    public String deleteSchool(@RequestParam int sid)
    {
        School school = repo.findById(sid).orElse(null);
        repo.delete(school);
        return "deleted";
    }

    @RequestMapping("/getSchool")
    public School getSchool(@RequestParam int sid)
    {
        School school = repo.findById(sid).orElse(new School());
        return school;
    }

    @RequestMapping("/schools")
    public List<School> allSchools()
    {
        return repo.findAll();
    }


}
