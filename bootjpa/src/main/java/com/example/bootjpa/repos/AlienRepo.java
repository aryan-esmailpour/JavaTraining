package com.example.bootjpa.repos;

import com.example.bootjpa.model.Alien;
import org.springframework.data.repository.CrudRepository;

public interface AlienRepo extends CrudRepository<Alien, Integer> {


}
