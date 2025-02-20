package org.example.moviedatabase.controller;

import jakarta.validation.Valid;
import org.example.moviedatabase.contract.MovieRequest;
import org.example.moviedatabase.model.Movie;
import org.example.moviedatabase.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MovieController {
    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies(){
        return movieService.list();
    }

    @PostMapping("/movies")
    public ResponseEntity<?> postMovie(@RequestBody @Valid MovieRequest movie){
        try {
            var ret = movieService.create(movie);
            return ResponseEntity.ok(ret);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable("id") Long id){
        return movieService.read(id);
    }

    @PutMapping("/movies")
    public Movie putMovie(@RequestBody @Valid MovieRequest movie){
        return movieService.update(movie);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable("id") Long id){
        movieService.delete(id);
    }

    @PostMapping("/movies/search")
    public List<Movie> search(@RequestBody String query){
        return movieService.search(query);
    }

}
