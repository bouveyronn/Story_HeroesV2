package com.storyheroes.app.service;

import com.storyheroes.app.model.Etape;
import com.storyheroes.app.repository.EtapeRepository;
import com.storyheroes.app.repository.Histoire_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtapeService {

    //Déclaration des repository
    @Autowired
    private EtapeRepository etapeRepo;

    public List<Etape> getEtapes(Long idHistoire){
        return etapeRepo.findAll();
    }

}
