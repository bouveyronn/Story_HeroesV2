package com.storyheroes.app.service;

import com.storyheroes.app.model.Etape;
import com.storyheroes.app.model.Histoire;
import com.storyheroes.app.repository.EtapeRepository;
import com.storyheroes.app.repository.HistoireEtapeRepository;
import com.storyheroes.app.repository.HistoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EtapeService {

    //Déclaration des repository
    @Autowired
    private EtapeRepository etapeRepo;
    @Autowired
    private HistoireRepository histoireRepo;
    @Autowired
    private HistoireEtapeRepository histoireEtapeRepo;


    public List<Etape> getEtapesByStory(Long idHistoire) {

        if (histoireRepo.findById(idHistoire).isPresent()) {
            Histoire unehistoire = histoireRepo.findById(idHistoire).get();
            List<Etape> histoireEtape = unehistoire.getEtapes();
            for (Etape etape : histoireEtape) {
                Long etapeId = etape.getId();
                Long histoireId = unehistoire.getId();
                Long num_etape = histoireEtapeRepo.findNumEtape(histoireId, etapeId);
                etape.setNum_etape(num_etape);
            }

            return histoireRepo.findById(idHistoire).get().getEtapes();

        }
        throw new EntityNotFoundException("Oops ! Aucun résultat pour cette recherche.");
    }


    public Etape getEtapeById(Long  idHistoire,Long idEtape) {
        Etape correctEtape = null;
        if (histoireRepo.findById(idHistoire).isPresent()) {
            Histoire unehistoire = histoireRepo.findById(idHistoire).get();
            List<Etape> histoireEtape = unehistoire.getEtapes();
            for (Etape etape : histoireEtape) {
                Long etapeId = etape.getId();
                Long histoireId = unehistoire.getId();
                Long num_etape = histoireEtapeRepo.findNumEtape(histoireId, etapeId);
                etape.setNum_etape(num_etape);

                if (num_etape.equals(idEtape)){
                    correctEtape = etape;
                }
            }

            return correctEtape;

        }
        throw new EntityNotFoundException("Oops ! Aucun résultat pour cette recherche.");
    }
}
