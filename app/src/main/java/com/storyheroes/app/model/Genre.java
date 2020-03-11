package com.storyheroes.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle")
    private  String libelle;

    @ManyToMany
    @JoinTable(
            name = "histoire_genre",
            joinColumns = @JoinColumn(name = "fk_id_genre"),
            inverseJoinColumns = @JoinColumn(name = "fk_id_histoire"))
    List<Histoire> lesHistoires;

    public Genre(){

    }

    public Genre(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Histoire> getLesHistoires() {
        return lesHistoires;
    }

    public void setLesHistoires(List<Histoire> lesHistoires) {
        this.lesHistoires = lesHistoires;
    }
}
