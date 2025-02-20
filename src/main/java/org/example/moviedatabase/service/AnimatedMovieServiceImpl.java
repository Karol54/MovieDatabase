package org.example.moviedatabase.service;

import org.example.moviedatabase.contract.AnimatedMovieRequest;
import org.example.moviedatabase.exception.RecordNotFoundException;
import org.example.moviedatabase.model.AnimatedMovie;
import org.example.moviedatabase.repository.AnimatedMovieRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnimatedMovieServiceImpl implements AnimatedMovieService{

    private final AnimatedMovieRepository animatedMovieRepository;

    public AnimatedMovieServiceImpl(AnimatedMovieRepository animatedMovieRepository) {
        this.animatedMovieRepository = animatedMovieRepository;
    }

    @Override
    public AnimatedMovie create(AnimatedMovieRequest animatedMovie) {
        var toDb = new AnimatedMovie(animatedMovie);
        toDb.setCreated(LocalDateTime.now());
        return animatedMovieRepository.save(toDb);
    }

    @Override
    public AnimatedMovie read(Long id) {
        if (id == null){
            throw new RecordNotFoundException(id, "Animated Movie");
        }
        return animatedMovieRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id, "Animated Movie"));
    }

    @Override
    public AnimatedMovie update(AnimatedMovieRequest animatedMovie) {
        var fromDb = read(animatedMovie.getId());
        if (fromDb == null){
            throw new RecordNotFoundException(animatedMovie.getId(), "Animated Movie");
        }
        fromDb.setTitle(animatedMovie.getTitle());
        fromDb.setDescription(animatedMovie.getDescription());
        fromDb.setReleaseDate(animatedMovie.getReleaseDate());
        fromDb.setTime(animatedMovie.getTime());
        fromDb.setGenre(animatedMovie.getGenre());
        fromDb.setScore(animatedMovie.getScore());
        fromDb.setUpdated(LocalDateTime.now());
        fromDb.setReview(animatedMovie.getReview());
        var ret = animatedMovieRepository.save(fromDb);

        return ret;
    }

    @Override
    public void delete(Long id) {
        var fromDb = read(id);
        if (fromDb == null){
            throw new RecordNotFoundException(id, "Animated Movie");
        }
        animatedMovieRepository.deleteById(id);
    }

    @Override
    public List<AnimatedMovie> list() {
        return animatedMovieRepository.findAll();
    }

    @Override
    public List<AnimatedMovie> search(String query) {
        return animatedMovieRepository.findAnimatedMovieByTitleContainingIgnoreCase(query);
    }


}
