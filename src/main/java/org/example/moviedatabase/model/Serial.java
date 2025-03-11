package org.example.moviedatabase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.moviedatabase.contract.SerialRequest;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Table(name = "Serials")
public class Serial {

    public Serial(SerialRequest request) {

    }

    public Serial() {}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private String title;
    private String description;
    private String releaseDate;
    private int episode;
    private int time;
    private String genre;
    private LocalDateTime created;
    private LocalDateTime updated;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "distribution_id", nullable=false)
    private Distribution distribution;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "rating_id", nullable = false)
    private Rating rating;

}
