package com.storyheroes.app.model;

import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Entity
@Table(name = "story")
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

    public Histoire() {
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
}
