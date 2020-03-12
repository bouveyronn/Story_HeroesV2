package com.storyheroes.app.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "genre")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle")
    private  String libelle;

    @ManyToMany(mappedBy = "genres")
    private Set<Histoire> histoires = new HashSet<>();

    public Genre(){

    }

    public Genre(Long id, String libelle, Set<Histoire> histoires) {
        this.id = id;
        this.libelle = libelle;
        this.histoires = histoires;
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

    public Set<Histoire> getHistoires() {
        return histoires;
    }

    public void setHistoires(Set<Histoire> histoires) {
        this.histoires = histoires;
    }
}
