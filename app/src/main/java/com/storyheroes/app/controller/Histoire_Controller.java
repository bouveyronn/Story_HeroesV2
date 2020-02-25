package com.storyheroes.app.controller;

import com.storyheroes.app.model.Histoire;
import com.storyheroes.app.repository.Histoire_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    

}
