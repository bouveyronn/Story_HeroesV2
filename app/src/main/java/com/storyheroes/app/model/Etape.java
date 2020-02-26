package com.storyheroes.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;

@Entity
@Table(name = "etape")
public class Etape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre")
    private  String titre;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String description;

    @Column(name = "est_une_fin")
    private Boolean est_une_fin;

    @ManyToOne
    @JoinColumn(name = "fk_id_story", nullable = false)
    private Histoire histoire;

    public Etape() {
    }

    public Etape(Long id, String titre, String image, String description, Boolean est_une_fin, Histoire histoire){
        this.id = id;
        this.titre = titre;
        this.image = image;
        this.description = description;
        this.est_une_fin = est_une_fin;
        this.histoire = histoire;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEst_une_fin() {
        return est_une_fin;
    }

    public void setEst_une_fin(Boolean est_une_fin) {
        this.est_une_fin = est_une_fin;
    }

    public Histoire getHistoire() {
        return histoire;
    }

    public void setHistoire(Histoire histoire) {
        this.histoire = histoire;
    }
}
