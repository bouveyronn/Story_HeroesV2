package com.storyheroes.app.multiplePK;

import javax.persistence.Column;
import java.io.Serializable;


public class HistoireGenrePK implements Serializable {
    @Column(name = "fk_id_histoire")
    private Long histoire;
    @Column(name = "fk_id_genre")
    private Long genre;
}
