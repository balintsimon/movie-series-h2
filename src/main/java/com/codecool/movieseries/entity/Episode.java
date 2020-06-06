package com.codecool.movieseries.entity;

import com.codecool.movieseries.repository.EpisodeRepository;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Episode {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Season season;

    private int length;

    @Column(unique = true, nullable = false)
    @EqualsAndHashCode.Exclude
    private String title;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Genre> genre;
}
