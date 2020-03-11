package com.storyheroes.app.service;

import com.storyheroes.app.model.Histoire;
import com.storyheroes.app.repository.HistoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class HistoireService {

    //Déclaration des repository
    @Autowired
    private HistoireRepository histoireRepo;


    public List<Histoire> getHistoires(){
        try{
            Thread.sleep(2000);
        }catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        return histoireRepo.findAll();
    }

    public Histoire getHistoireById(Long Id){

        if(histoireRepo.findById(Id).isPresent()){
            return histoireRepo.findById(Id).get();
        }throw new EntityNotFoundException("Oops ! Aucun résultat pour cette recherche.");

    }

    public List<Histoire> getHistoireBySearch(String search){
        List<Histoire> listHistoire = histoireRepo.findByTitreContaining(search);
        if (listHistoire.size() != 0){
            return histoireRepo.findByTitreContaining(search);
        }throw new EntityNotFoundException("Oops ! Aucun résultat pour cette recherche \" " + search + "\"");

    }

}
