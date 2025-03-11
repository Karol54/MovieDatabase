package org.example.moviedatabase.service;

import org.example.moviedatabase.contract.SerialRequest;
import org.example.moviedatabase.exception.RecordNotFoundException;
import org.example.moviedatabase.model.Serial;
import org.example.moviedatabase.repository.SerialRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SerialServiceImpl implements SerialService {

    private final SerialRepository serialRepository;

    public SerialServiceImpl(SerialRepository serialRepository) {this.serialRepository = serialRepository;}

    @Override
    public Serial create(SerialRequest serial) {
        var toDb = new Serial(serial);
        toDb.setCreated(LocalDateTime.now());
        return serialRepository.save(toDb);
    }

    @Override
    public Serial read(Long id) {
        if (id == null) {
            throw new RecordNotFoundException(id, "Serial");
        }
        return serialRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id, "Serial"));
    }

    @Override
    public Serial update(SerialRequest serial) {
        var fromDb = read(serial.getId());
        if (fromDb == null) {
            throw new RecordNotFoundException(serial.getId(), "Serial");
        }
        fromDb.setTitle(serial.getTitle());
        fromDb.setDescription(serial.getDescription());
        fromDb.setReleaseDate(serial.getReleaseDate());
        fromDb.setEpisode(serial.getEpisode());
        fromDb.setTime(serial.getTime());
        fromDb.setGenre(serial.getGenre());
        var ret = serialRepository.save(fromDb);

        return ret;
    }

    @Override
    public void delete(Long id) {
        var fromDb = read(id);
        if (fromDb == null) {
            throw new RecordNotFoundException(id, "Serial");
        }
        serialRepository.deleteById(id);
    }

    @Override
    public List<Serial> list() {
        return serialRepository.findAll();
    }

    @Override
    public List<Serial> search(String query) {
        return serialRepository.findSerialByTitleContainingIgnoreCase(query);
    }
}
