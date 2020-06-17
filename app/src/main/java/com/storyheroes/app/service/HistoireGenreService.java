package com.storyheroes.app.service;

import com.storyheroes.app.model.Histoire;
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

    @Autowired
    private HistoireRepository histoireRepository;

    public List<HistoireGenre> getHistoireGenre() {
        return histoireGenreRepository.findAll();
    }

    public List<HistoireGenre> getHistoireGenreByGenre(Long idGenre) {

        List<HistoireGenre>lst = histoireGenreRepository.findByGenre(idGenre);
        for(HistoireGenre histoire:lst){
            Histoire uneHistoire = histoireRepository.getById(histoire.getHistoire());
            histoire.setUneHistoire(uneHistoire);
        }
        return histoireGenreRepository.findByGenre(idGenre);
    }

    public void ajouterGenrePourUneHistoire(HistoireGenre histoireGenre) {
        this.histoireGenreRepository.save(histoireGenre);
    }
}
