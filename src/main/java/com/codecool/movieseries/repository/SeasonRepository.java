package com.codecool.movieseries.repository;

import com.codecool.movieseries.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeasonRepository extends JpaRepository<Season, Long> {
    @Query(value = "SELECT s FROM Season s")
    List<Season> findAll();
}
