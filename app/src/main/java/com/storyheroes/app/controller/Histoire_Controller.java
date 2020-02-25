package com.storyheroes.app.controller;

import com.storyheroes.app.model.Histoire;
import com.storyheroes.app.repository.Histoire_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/histoire")
@CrossOrigin
public class Histoire_Controller {

    @Autowired
    private Histoire_Repository histoireRepo;

    @GetMapping
    public List<Histoire> getHistoire(){

        try{
            Thread.sleep(2000);
        }catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        return histoireRepo.findAll();
    }

    @GetMapping(params = "q")
    public List<Histoire> getHistoireBySearch(@RequestParam(name = "q") String search){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        return histoireRepo.findByTitreContaining(search);
    }

    

}
