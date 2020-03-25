package com.storyheroes.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "choix")
public class Choix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "libelle")
    private  String libelle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destination", nullable = false)
    @JsonIgnoreProperties(value = "choix")
    private Etape destination;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_etape", nullable = false)
    private Etape etape;

    public Choix() {
    }

    public Choix(long id, String libelle, Etape destination, Etape etape) {
        this.id = id;
        this.libelle = libelle;
        this.destination = destination;
        this.etape = etape;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Etape getDestination() {
        return destination;
    }

    public void setDestination(Etape destination) {
        this.destination = destination;
    }

    public Etape getEtape() {
        return etape;
    }

    public void setEtape(Etape etape) {
        this.etape = etape;
    }
}
