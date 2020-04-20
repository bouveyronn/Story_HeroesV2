package com.storyheroes.app.repository;

import com.storyheroes.app.model.Histoire;
import com.storyheroes.app.model.HistoireGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoireGenreRepository extends JpaRepository<HistoireGenre, Long> {
    List<HistoireGenre> findByGenre(Long fk_id_genre);
}
