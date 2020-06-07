package com.codecool.movieseries.entity;

import com.codecool.movieseries.repository.EpisodeRepository;
import com.codecool.movieseries.repository.SeasonRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Series {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    @Transient
    private int numberOfSeasons;

    @OneToMany(mappedBy = "series", cascade = CascadeType.PERSIST)
    @EqualsAndHashCode.Exclude
//    @ToString.Exclude // TODO: check if we actually need this
    private List<Season> seasons;
}
