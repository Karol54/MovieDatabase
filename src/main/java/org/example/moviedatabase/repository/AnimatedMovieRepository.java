package org.example.moviedatabase.repository;

import org.example.moviedatabase.model.AnimatedMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimatedMovieRepository extends JpaRepository<AnimatedMovie, Long> {
    List<AnimatedMovie> findAnimatedMovieByTitleContainingIgnoreCase(String title);

}
