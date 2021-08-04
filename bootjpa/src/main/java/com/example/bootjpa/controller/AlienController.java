package com.example.bootjpa.controller;

import com.example.bootjpa.model.Alien;
import com.example.bootjpa.repos.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AlienController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/home")
    public String home()
    {
        return "home.html";
    }

    @RequestMapping("/addAlien")
    public ModelAndView addAlien(Alien alien)
    {
        repo.save(alien);
        ModelAndView mv = new ModelAndView("home.html");
        return mv;
        //return "home.html";
    }

    @RequestMapping("/getAlien")
    public Alien getAlien(@RequestParam int aid)
    {
        //ModelAndView mv = new ModelAndView("show.html");
        Alien alien = repo.findById(aid).orElse(new Alien());
        //mv.addObject(alien);
        //return mv;
        return alien;
    }


}
