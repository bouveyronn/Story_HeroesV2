package com.storyheroes.app.controller;

import com.storyheroes.app.model.Genre;
import com.storyheroes.app.model.Histoire;
import com.storyheroes.app.service.GenreService;
import com.storyheroes.app.service.HistoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    //Déclaration des services
    @Autowired
    private GenreService genreService;

    @GetMapping
    public List<Genre> getAllGenres(){
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable(name = "id")Long id){
        return genreService.getGenreById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createGenre(@RequestBody Genre genre){
        this.genreService.ajouterGenre(genre);
    }
}
