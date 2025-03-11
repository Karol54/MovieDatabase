package org.example.moviedatabase.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Getter
@Setter
@Table(name = "Ratings")
public class Rating {
    public Rating() {}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int score;
    private String review;
    private double totalRatings;

    @OneToMany(mappedBy = "rating")
    private List<Movie> movies;

    @OneToMany(mappedBy = "rating")
    private List<Serial> serials;



}
