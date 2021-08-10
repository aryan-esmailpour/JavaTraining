package com.example.bootjpa.services;

import com.example.bootjpa.model.Alien;
import com.example.bootjpa.repos.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlienService {
    @Autowired
    AlienRepo repo;

    public void getStudentsMap()
    {
        List<Alien> students = repo.findAll();
        Map<String, Integer> studentsMap = new HashMap<>();
        for(int i = 0; i < students.size(); i++)
        {
            Alien student = students.get(i);
            studentsMap.put(student.getAname(), student.getAgrade());
        }
        System.out.println("Hi");
        studentsMap.entrySet().stream().forEach(e-> System.out.println(e));
    }
}
