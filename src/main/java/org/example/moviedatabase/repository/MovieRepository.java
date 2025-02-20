package org.example.moviedatabase.repository;

import org.example.moviedatabase.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findMoviesByTitleContainingIgnoreCase(String title);
}
