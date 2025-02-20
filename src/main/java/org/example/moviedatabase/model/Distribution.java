package org.example.moviedatabase.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.moviedatabase.contract.DistributionRequest;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Table(name = "Distributions")
public class Distribution {

    public Distribution(){}

    public Distribution(DistributionRequest distribution){
        id = distribution.getId();
        name = distribution.getName();
        foundedYear = distribution.getFoundedYear();
        location = distribution.getLocation();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private int foundedYear;
    private String location;
    private LocalDateTime created;
    private LocalDateTime updated;

    @OneToMany(mappedBy = "distribution")
    private List<Movie> movies;

    @OneToMany(mappedBy = "distribution")
    private List<AnimatedMovie> animatedMovies;

    @OneToMany(mappedBy = "distribution")
    private List<Serial> serials;

}
