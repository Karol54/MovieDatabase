package org.example.moviedatabase.service;

import org.example.moviedatabase.contract.MovieRequest;
import org.example.moviedatabase.exception.RecordNotFoundException;
import org.example.moviedatabase.model.Movie;
import org.example.moviedatabase.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie create(MovieRequest movie) {
        var toDb = new Movie(movie);
        toDb.setCreated(LocalDateTime.now());
        return movieRepository.save(toDb);
    }

    @Override
    public Movie read(Long id) {
        if (id == null){
            throw new RecordNotFoundException(id, "Movie");
        }
        return movieRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id, "Movie"));
    }

    @Override
    public Movie update(MovieRequest movie) {
        var fromDb = read(movie.getId());
        if (fromDb == null){
            throw new RecordNotFoundException(movie.getId(), "Movie");
        }
        fromDb.setTitle(movie.getTitle());
        fromDb.setDescription(movie.getDescription());
        fromDb.setReleaseDate(movie.getReleaseDate());
        fromDb.setTime(movie.getTime());
        fromDb.setGenre(movie.getGenre());
        fromDb.setScore(movie.getScore());
        fromDb.setUpdated(LocalDateTime.now());
        fromDb.setReview(movie.getReview());
        var ret = movieRepository.save(fromDb);

        return ret;
    }

    @Override
    public void delete(Long id) {
        var fromDb = read(id);
        if (fromDb == null){
            throw new RecordNotFoundException(id, "Movie");
        }
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> list() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> search(String query) {
        return movieRepository.findMoviesByTitleContainingIgnoreCase(query);
    }

}
