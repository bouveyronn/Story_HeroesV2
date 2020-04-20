package com.storyheroes.app.service;

import com.storyheroes.app.model.Genre;
import com.storyheroes.app.repository.EtapeRepository;
import com.storyheroes.app.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    //Déclaration des repository
    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }

    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).get();
    }

    public void ajouterGenre(Genre genre) {
        genreRepository.save(genre);
    }
}
