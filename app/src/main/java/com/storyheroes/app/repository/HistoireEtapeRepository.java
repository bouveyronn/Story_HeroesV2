package com.storyheroes.app.repository;

import com.storyheroes.app.model.HistoireEtape;

import com.storyheroes.app.multiplePK.HistoireEtapePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HistoireEtapeRepository  extends JpaRepository<HistoireEtape, Long> {

    @Query("select he.num_etape from HistoireEtape he where he.histoire = ?1 and he.etape = ?2")
    Long findNumEtape(Long fk_id_histoire, Long fk_id_etape);
}
