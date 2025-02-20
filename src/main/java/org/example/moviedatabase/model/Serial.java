package org.example.moviedatabase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Entity
@Table(name = "Serials")
public class Serial {

    public Serial() {}

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
    @JoinColumn(name = "distribution_id", nullable=false)
    private Distribution distribution;



}
