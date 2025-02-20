package org.example.moviedatabase.service;

import org.example.moviedatabase.contract.AnimatedMovieRequest;
import org.example.moviedatabase.model.AnimatedMovie;

import java.util.List;

public interface AnimatedMovieService {
    AnimatedMovie create(AnimatedMovieRequest animatedMovie);
    AnimatedMovie read(Long id);
    AnimatedMovie update(AnimatedMovieRequest animatedMovie);
    void delete(Long id);
    List<AnimatedMovie> list();
    List<AnimatedMovie> search(String query);
}

