package org.example.moviedatabase.service;

import org.example.moviedatabase.contract.MovieRequest;
import org.example.moviedatabase.model.Movie;

import java.util.List;

public interface MovieService {
    Movie create(MovieRequest movie);
    Movie read(Long id);
    Movie update(MovieRequest movie);
    void delete(Long id);
    List<Movie> list();
    List<Movie> search(String query);
    //List<Movie> searchGenre(String query);


}
