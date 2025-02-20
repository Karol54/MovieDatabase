package org.example.moviedatabase.service;


import org.example.moviedatabase.exception.RecordNotFoundException;
import org.example.moviedatabase.model.Movie;
import org.example.moviedatabase.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieServiceImplTest {
    @Mock
    private MovieRepository movieRepository;

    private MovieServiceImpl movieService;

    @BeforeEach
    void setUp() {
        movieService = new MovieServiceImpl(movieRepository);
    }

    @Test
    void testDeleteExistingMovie() {
        // Předpokládané vstupy
        Long movieId = 55L;
        Movie movie = new Movie();

        // Nastavení chování metody findById() na mock objektu movieRepository
        when(movieRepository.findById(movieId)).thenReturn(Optional.of(movie));

        // Volání testované metody
        movieService.delete(movieId);

        // Ověření, že byla zavolána metoda deleteById() s očekávaným argumentem
        verify(movieRepository).deleteById(movieId);
    }

    @Test
    void testDeleteNoExistingMovie() {
        // Předpokládané vstupy
        Long noExistingMovieId = 1L;

        // Nastavení chování metody findById() na mock objektu movieRepository
        when(movieRepository.findById(noExistingMovieId)).thenReturn(Optional.empty());

        // Ověření, že volání delete() vyvolá výjimku RecordNotFoundException
        assertThrows(RecordNotFoundException.class, () -> {
            movieService.delete(noExistingMovieId);
        });

        // Ověření, že metoda deleteById() nebyla volána
        verify(movieRepository, never()).deleteById(noExistingMovieId);
    }

}


