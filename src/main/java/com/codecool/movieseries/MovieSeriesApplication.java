package com.codecool.movieseries;

import com.codecool.movieseries.entity.Episode;
import com.codecool.movieseries.entity.Genre;
import com.codecool.movieseries.entity.Season;
import com.codecool.movieseries.entity.Series;
import com.codecool.movieseries.repository.EpisodeRepository;
import com.codecool.movieseries.repository.SeasonRepository;
import com.codecool.movieseries.repository.SeriesRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MovieSeriesApplication {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    public static void main(String[] args) {
        SpringApplication.run(MovieSeriesApplication.class, args);
    }

    @Bean // create and save entity in repo
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            Series GoT = Series.builder()
                    .title("Game of Thrones")
                    .build();

            Season GoTSeason1 = Season.builder()
                    .seasonNumber(1)
                    .releaseYear(2010)
                    .series(GoT)
                    .build();

            Season GoTSeason2 = Season.builder()
                    .seasonNumber(1)
                    .releaseYear(2010)
                    .series(GoT)
                    .build();

            Episode GoTEp1 = Episode.builder()
                    .title("GoT Ep 1")
                    .season(GoTSeason1)
                    .genre(Lists.newArrayList(Genre.FANTASY))
                    .build();

            GoT.setSeasons(Arrays.asList(GoTSeason1, GoTSeason2));
            GoTSeason1.setEpisodes(Arrays.asList(GoTEp1));

            seriesRepository.save(GoT);

            List<Season> seasonList = seasonRepository.findAllBySeasonNumber(1);
            System.out.println("Got season list ");
            for (Season season : seasonList) {
                System.out.println(season.getSeasonNumber());
            }
        };
    }
}
