package com.codecool.movieseries.repository;

import com.codecool.movieseries.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
