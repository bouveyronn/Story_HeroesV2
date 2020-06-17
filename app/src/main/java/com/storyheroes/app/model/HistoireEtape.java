package com.storyheroes.app.model;

import com.storyheroes.app.multiplePK.HistoireEtapePK;

import javax.persistence.*;

@Entity
@IdClass(HistoireEtapePK.class)
@Table(name = "histoire_etape")
public class HistoireEtape {

    @Id
    @Column(name = "fk_id_histoire")
    private Long histoire;

    @Id
    @Column(name = "fk_id_etape")
    private Long etape;

    @Column(name = "num_etape")
    private Long num_etape;

    public HistoireEtape() {
    }

    public HistoireEtape(Long fk_id_histoire, Long fk_id_etape, Long num_etape) {
        this.histoire = fk_id_histoire;
        this.etape = fk_id_etape;
        this.num_etape = num_etape;
    }

    public Long getHistoire() {
        return histoire;
    }

    public void setHistoire(Long histoire) {
        this.histoire = histoire;
    }

    public Long getEtape() {
        return etape;
    }

    public void setEtape(Long etape) {
        this.etape = etape;
    }

    public Long getNum_etape() { return num_etape; }

    public void setNum_etape(Long num_etape) { this.num_etape = num_etape; }
}
