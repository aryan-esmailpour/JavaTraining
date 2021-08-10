package com.example.bootjpa.controller;

import com.example.bootjpa.model.Alien;
import com.example.bootjpa.repos.AlienRepo;
import com.example.bootjpa.services.AlienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AdminController {

    @Autowired
    AlienRepo repo;
    @Autowired
    AlienService service;

    @RequestMapping("/admin")
    public ModelAndView home()
    {
        ModelAndView mv = new ModelAndView("admin.html");
        return mv;
    }

    @RequestMapping("/filterStudents")
    public List<String> filterStudents(@RequestParam int grade)
    {
        List <Alien> students = repo.findAll();
        Map<String, Integer> studentsMap = new HashMap<>();
        for(int i = 0; i < students.size(); i++)
        {
            Alien student = students.get(i);
            studentsMap.put(student.getAname(), student.getAgrade());
        }
        List<String> results = studentsMap.entrySet().stream()
                .filter(e -> e.getValue() > grade)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return results;
    }

    @Scheduled(fixedRate = 300000L)
    void averageGrades()
    {
        double avg = 0;
        List<Alien> students = repo.findAll();
        int sz = students.size();
        for(int i = 0; i < sz; i++)
        {
            avg += students.get(i).getAgrade();
        }
        if(avg == 0)
        {
            System.out.println(0);
        }
        else
        {
            avg = avg / (double) sz;
            System.out.println(avg);
        }
    }

    @PostConstruct
    void studentsMapPrint()
    {
        service.getStudentsMap();
    }

}

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
class SchedulingConfiguration{

}
