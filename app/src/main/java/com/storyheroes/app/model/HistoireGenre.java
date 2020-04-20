package com.storyheroes.app.model;

import com.storyheroes.app.multiplePK.HistoireGenrePK;

import javax.persistence.*;

@Entity
@IdClass(HistoireGenrePK.class)
@Table(name = "histoire_genre")
public class HistoireGenre {

    @Id
    @Column(name = "fk_id_histoire")
    private Long histoire;

    @Id
    @Column(name = "fk_id_genre")
    private Long genre;

    public HistoireGenre() {
    }

    public HistoireGenre(Long fk_id_histoire, Long fk_id_genre) {
        this.histoire = fk_id_histoire;
        this.genre = fk_id_genre;
    }

    public Long getHistoire() {
        return histoire;
    }

    public void setHistoire(Long histoire) {
        this.histoire = histoire;
    }

    public Long getGenre() {
        return genre;
    }

    public void setGenre(Long genre) {
        this.genre = genre;
    }
}
