package com.example.bootjpa.controller;

import com.example.bootjpa.model.Alien;
import com.example.bootjpa.repos.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/alien")
    public Alien addAlien(Alien alien)
    {
        repo.save(alien);
        return alien;
        //return "home.html";
    }

    @DeleteMapping("/alien")
    public String deleteAlien(@RequestParam int aid)
    {
        Alien alien = repo.findById(aid).orElse(new Alien());
        repo.delete(alien);
        return "deleted";
    }
    @GetMapping("/alien")
    public Alien getAlien(@RequestParam int aid)
    {
        //ModelAndView mv = new ModelAndView("show.html");
        Alien alien = repo.findById(aid).orElse(new Alien());
        //mv.addObject(alien);
        //return mv;
        return alien;
    }


}
