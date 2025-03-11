package org.example.moviedatabase.service;

import org.example.moviedatabase.contract.MovieRequest;
import org.example.moviedatabase.contract.SerialRequest;
import org.example.moviedatabase.model.Movie;
import org.example.moviedatabase.model.Serial;

import java.util.List;

public interface SerialService {
    Serial create(SerialRequest serial);
    Serial read(Long id);
    Serial update(SerialRequest serial);
    void delete(Long id);
    List<Serial> list();
    List<Serial> search(String query);
}
