package com.codecool.movieseries;

import com.codecool.movieseries.entity.Episode;
import com.codecool.movieseries.entity.Genre;
import com.codecool.movieseries.repository.EpisodeRepository;
import com.codecool.movieseries.repository.SeasonRepository;
import com.codecool.movieseries.repository.SeriesRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

//@SpringBootTest
@ExtendWith({SpringExtension.class})
@DataJpaTest
@ActiveProfiles("test")
class AllMovieSeriesApplicationTests {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void saveOneEpisode() {
        Episode GoTEp1 = Episode.builder()
                .title("GoT Ep 1")
                .genre(Lists.newArrayList(Genre.FANTASY))
                .build();

        episodeRepository.save(GoTEp1);

        List<Episode> episodeList = episodeRepository.findAll();
        assertThat(episodeList).hasSize(1);
    }

    @Test
    public void saveUniqueFieldTwice() {

        Episode GoTEp1 = Episode.builder()
                .title("GoT Ep 1")
                .genre(Lists.newArrayList(Genre.FANTASY))
                .build();

        Episode GoTEp2 = Episode.builder()
                .title("GoT Ep 1")
                .genre(Lists.newArrayList(Genre.FANTASY))
                .build();

        episodeRepository.save(GoTEp1);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> episodeRepository.save(GoTEp2));
    }

    @Test
    public void episodeTitleShouldNotBeNull() {
        Episode GoTEp1 = Episode.builder()
                .genre(Lists.newArrayList(Genre.FANTASY))
                .build();
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> episodeRepository.save(GoTEp1));
    }
}
