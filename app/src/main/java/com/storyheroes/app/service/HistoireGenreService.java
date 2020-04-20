package com.storyheroes.app.service;

import com.storyheroes.app.model.HistoireGenre;
import com.storyheroes.app.repository.HistoireGenreRepository;
import com.storyheroes.app.repository.HistoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoireGenreService {
    //Déclaration des repository
    @Autowired
    private HistoireGenreRepository histoireGenreRepository;

    public List<HistoireGenre> getHistoireGenre() {
        return histoireGenreRepository.findAll();
    }

    public List<HistoireGenre> getHistoireGenreByGenre(Long idGenre) {
        return histoireGenreRepository.findByGenre(idGenre);
    }

    public void ajouterGenrePourUneHistoire(HistoireGenre histoireGenre) {
        this.histoireGenreRepository.save(histoireGenre);
    }
}
