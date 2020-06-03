package com.codecool.movieseries;

import com.codecool.movieseries.repository.SeriesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith({SpringExtension.class})
@DataJpaTest
@ActiveProfiles("test")
class AllMovieSeriesApplicationTests {

    //    @Autowired
//    private EpisodeRepository episodeRepository;
//
//    @Autowired
//    private SeasonRepository seasonRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    @Test
    void contextLoads() {
    }

}
