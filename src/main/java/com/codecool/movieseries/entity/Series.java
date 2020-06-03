package com.codecool.movieseries.entity;

import lombok.*;

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
    private List<Season> seasons;
}
