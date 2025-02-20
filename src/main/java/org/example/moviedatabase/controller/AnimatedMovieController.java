package org.example.moviedatabase.controller;

import jakarta.validation.Valid;
import org.example.moviedatabase.contract.AnimatedMovieRequest;
import org.example.moviedatabase.model.AnimatedMovie;
import org.example.moviedatabase.model.Movie;
import org.example.moviedatabase.service.AnimatedMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AnimatedMovieController {
    private final AnimatedMovieService animatedMovieService;

    public AnimatedMovieController(AnimatedMovieService animatedMovieService){
        this.animatedMovieService = animatedMovieService;
    }

    @GetMapping("/animatedMovies")
    public List<AnimatedMovie> getAnimatedMovies(){
        return animatedMovieService.list();
    }

    @PostMapping("/animatedMovies")
    public ResponseEntity<?> postMovie(@RequestBody @Valid AnimatedMovieRequest animatedMovie){
        try {
            var ret = animatedMovieService.create(animatedMovie);
            return ResponseEntity.ok(ret);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/animatedMovies/{id}")
    public AnimatedMovie getMovie(@PathVariable("id") Long id){
        return animatedMovieService.read(id);
    }

    @PutMapping("/animatedMovies")
    public AnimatedMovie putMovie(@RequestBody @Valid AnimatedMovieRequest animatedMovie){
        return animatedMovieService.update(animatedMovie);
    }

    @DeleteMapping("/animatedMovies/{id}")
    public void deleteMovie(@PathVariable("id") Long id){
        animatedMovieService.delete(id);
    }

    @PostMapping("/animatedMovies/search")
    public List<AnimatedMovie> search(@RequestBody String query){
        return animatedMovieService.search(query);
    }
}
