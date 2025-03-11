package org.example.moviedatabase.repository;

import org.example.moviedatabase.model.Movie;
import org.example.moviedatabase.model.Serial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerialRepository extends JpaRepository<Serial, Long> {
    List<Serial> findSerialByTitleContainingIgnoreCase(String title);

}
