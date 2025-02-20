package org.example.moviedatabase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RecordNotFoundException extends ResponseStatusException {
    public RecordNotFoundException(Long id, String type) {
        super(HttpStatus.NOT_FOUND, String.format("This %s record with ID %d was not found", type, id));

    }
}
