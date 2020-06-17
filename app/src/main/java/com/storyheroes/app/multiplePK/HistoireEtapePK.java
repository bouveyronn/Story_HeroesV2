package com.storyheroes.app.multiplePK;

import javax.persistence.Column;
import java.io.Serializable;


public class HistoireEtapePK implements Serializable {
    @Column(name = "fk_id_histoire")
    private Long histoire;
    @Column(name = "fk_id_etape")
    private Long etape;
    @Column(name = "num_etape")
    private Long num_etape;

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

    public Long getNum_etape() {
        return num_etape;
    }

    public void setNum_etape(Long num_etape) {
        this.num_etape = num_etape;
    }
}
