package com.storyheroes.app.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "histoire")
public class Histoire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre")
    private  String titre;

    @Column(name = "resume")
    private String resume;

    @Column(name = "est_publie")
    private Boolean est_publiee;

    @Column(name = "image")
    private String image;

    @Column(name = "fk_id_auteur")
    private Long fk_id_auteur = 1L;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "histoire")
    @JsonIgnoreProperties(value = "histoire")
    private List<Etape> etapes;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "histoire_genre",
            joinColumns = {@JoinColumn(name = "fk_id_histoire")},
            inverseJoinColumns = {@JoinColumn(name = "fk_id_genre")}
    )
    @JsonIgnoreProperties(value = {"histoires"})
    Set<Genre> genres = new HashSet<>();

    @Transient
    private Long num_etape;

    public Histoire() {
    }

    public Histoire(Long id, String titre, String resume, Boolean est_publiee, String image, Long fk_id_auteur, List<Etape> etapes, Set<Genre> genres) {
        this.id = id;
        this.titre = titre;
        this.resume = resume;
        this.est_publiee = est_publiee;
        this.image = image;
        this.fk_id_auteur = fk_id_auteur;
        this.etapes = etapes;
        this.genres = genres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Boolean getEst_publiee() {
        return est_publiee;
    }

    public void setEst_publiee(Boolean est_publiee) {
        this.est_publiee = est_publiee;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Etape> getEtapes() {
        return etapes;
    }

    public void setEtapes(List<Etape> etapes) {
        this.etapes = etapes;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Long getFk_id_auteur() {
        return fk_id_auteur;
    }

    public void setFk_id_auteur(Long fk_id_auteur) {
        this.fk_id_auteur = fk_id_auteur;
    }
}
