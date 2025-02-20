package org.example.moviedatabase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.moviedatabase.contract.AnimatedMovieRequest;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "AnimatedMovies")
public class AnimatedMovie {

    public AnimatedMovie() {}

    public AnimatedMovie(AnimatedMovieRequest request){
        id = request.getId();
        title = request.getTitle();
        description = request.getDescription();
        releaseDate = request.getReleaseDate();
        time = request.getTime();
        genre = request.getGenre();
        score = request.getScore();
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
    private String review;
    private LocalDateTime created;
    private LocalDateTime updated;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "distribution_id", nullable=false)
    private Distribution distribution;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public Distribution getDistribution() {
        return distribution;
    }

    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
