package com.storyheroes.app.controller;

import com.storyheroes.app.model.Histoire;
import com.storyheroes.app.model.HistoireGenre;
import com.storyheroes.app.service.HistoireGenreService;
import com.storyheroes.app.service.HistoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/histoire-genre")
public class HistoireGenreController {
    //Déclaration des services
    @Autowired
    private HistoireGenreService histoireGenreService;

    @GetMapping
    public List<HistoireGenre> getHistoireGenre(){
        return histoireGenreService.getHistoireGenre();
    }
    @GetMapping("/{idGenre}")
    public List<HistoireGenre> getHistoireGenreByGenre(@PathVariable(name = "idGenre")Long idGenre){
        return histoireGenreService.getHistoireGenreByGenre(idGenre);
    }
}
