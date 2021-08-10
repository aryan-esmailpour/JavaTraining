package com.example.bootjpa.controller;

import com.example.bootjpa.model.Alien;
import com.example.bootjpa.model.School;
import com.example.bootjpa.repos.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class AlienController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/home")
    public ModelAndView home()
    {
        ModelAndView mv = new ModelAndView("home.html");
        return mv;
    }

    @RequestMapping("/addStudent")
    public Alien addAlien(Alien alien)
    {
        School school = alien.getSchool();
        school.addToStudents(alien);
        repo.save(alien);
        return alien;
        //return "home.html";
    }

    @RequestMapping("/deleteStudent")
    public String deleteAlien(@RequestParam int aid)
    {
        Alien alien = repo.findById(aid).orElse(null);
        repo.delete(alien);
        return "deleted";
    }

    @RequestMapping("/getStudent")
    public Alien getAlien(@RequestParam int aid)
    {
        //ModelAndView mv = new ModelAndView("show.html");
        Alien alien = repo.findById(aid).orElse(new Alien());
        //mv.addObject(alien);
        //return mv;
        return alien;
    }

    @RequestMapping("/students")
    public List<Alien> allAliens()
    {
        return repo.findAll();
    }




}
