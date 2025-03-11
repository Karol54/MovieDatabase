package org.example.moviedatabase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.moviedatabase.contract.MovieRequest;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Table(name = "Movies")
public class Movie {

    public Movie(){}

    public Movie(MovieRequest request){
        id = request.getId();
        title = request.getTitle();
        description = request.getDescription();
        releaseDate = request.getReleaseDate();
        time = request.getTime();
        genre = request.getGenre();
        score = request.getScore();
        review = request.getReview();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private String title;
    private String description;
    private String releaseDate;
    private int time;
    private String genre;
    private int score;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String review;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "distribution_id", nullable = false)
    private Distribution distribution;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "rating_id", nullable = false)
    private Rating rating;


}
