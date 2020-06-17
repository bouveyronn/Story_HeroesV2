package com.storyheroes.app.service;

import com.storyheroes.app.model.Etape;
import com.storyheroes.app.model.Histoire;
import com.storyheroes.app.repository.HistoireEtapeRepository;
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

    @Autowired
    private HistoireEtapeRepository histoireEtapeRepo;


    public List<Histoire> getHistoires(){
        try{
            Thread.sleep(500);
        }catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        return histoireRepo.findAll();
    }

    public Histoire getHistoireById(Long Id){

        if(histoireRepo.findById(Id).isPresent()){
            Histoire unehistoire = histoireRepo.findById(Id).get();
            List<Etape> histoireEtape = unehistoire.getEtapes();
            for (Etape etape : histoireEtape){
                Long idEtape = etape.getId();
                Long idHistoire = unehistoire.getId();
                Long num_etape = histoireEtapeRepo.findNumEtape(idHistoire, idEtape);
                etape.setNum_etape(num_etape);
            }

            return histoireRepo.findById(Id).get();
        }throw new EntityNotFoundException("Oops ! Aucun résultat pour cette recherche.");

    }

    public List<Histoire> getHistoireBySearch(String search){
        List<Histoire> listHistoire = histoireRepo.findByTitreContaining(search);
        if (listHistoire.size() != 0){
            return histoireRepo.findByTitreContaining(search);
        }throw new EntityNotFoundException("Oops ! Aucun résultat pour cette recherche \" " + search + "\"");

    }

    public void ajouterHistoire(Histoire histoire) {
        this.histoireRepo.save(histoire);
    }
}
