package com.codecool.movieseries.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Season {

    @Id
    @GeneratedValue
    private Long id;

    private int seasonNumber;
    private int releaseYear;

    @ManyToOne
//    @Column(unique = true, nullable = false)
    private Series series;

    @OneToMany(mappedBy = "season", cascade = CascadeType.PERSIST)
    @EqualsAndHashCode.Exclude
    private List<Episode> episodes;


}
