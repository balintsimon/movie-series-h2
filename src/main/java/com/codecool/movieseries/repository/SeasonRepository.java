package com.codecool.movieseries.repository;

import com.codecool.movieseries.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
