package com.storyheroes.app.controller;

import com.storyheroes.app.model.Etape;
import com.storyheroes.app.service.EtapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/etapes/{idHistoire}")
public class EtapeController {

    @Autowired
    private EtapeService etapeService;

    @GetMapping
    public List<Etape> getEtapes(@PathVariable(name = "idHistoire")Long idHistoire){
        return etapeService.getEtapesByStory(idHistoire);
    }

}
