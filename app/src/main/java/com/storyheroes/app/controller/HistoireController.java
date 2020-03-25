package com.storyheroes.app.controller;

import com.storyheroes.app.model.Histoire;
import com.storyheroes.app.service.HistoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/histoires")
public class HistoireController {

    //Déclaration des services
    @Autowired
    private HistoireService histoireService;



    @GetMapping
    public List<Histoire> getHistoires(){
        return histoireService.getHistoires();
    }

    @GetMapping("/{id}")
    public Histoire getHistoire(@PathVariable(name = "id")Long id){
        return  histoireService.getHistoireById(id);
    }

    @GetMapping(params = "q")
    public List<Histoire> getHistoireBySearch(@RequestParam(name = "q") String search){
        return histoireService.getHistoireBySearch(search);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createHistoire(@RequestBody Histoire histoire){
        this.histoireService.ajouterHistoire(histoire);
    }



}
