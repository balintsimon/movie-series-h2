package com.codecool.movieseries.repository;

import com.codecool.movieseries.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {

    int findByNumberOfSeasons();
}
