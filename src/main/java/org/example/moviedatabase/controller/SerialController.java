package org.example.moviedatabase.controller;

import jakarta.validation.Valid;
import org.example.moviedatabase.contract.SerialRequest;
import org.example.moviedatabase.model.Serial;
import org.example.moviedatabase.service.SerialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SerialController {
    private final SerialService serialService;

    public SerialController(SerialService serialService) {
        this.serialService = serialService;
    }

    @GetMapping("/serials")
    public List<Serial> getSerials(){
        return serialService.list();
    }

    @PostMapping("/serials")
    public ResponseEntity<?> postSerial(@RequestBody @Valid SerialRequest serial){
        try {
            var ret = serialService.create(serial);
            return ResponseEntity.ok(ret);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/serials/{id}")
    public Serial getSerial(@PathVariable("id") Long id){
        return serialService.read(id);
    }

    @PutMapping("/serials")
    public Serial putMovie(@RequestBody @Valid SerialRequest serial){
        return serialService.update(serial);
    }

    @DeleteMapping("/serials/{id}")
    public void deleteSerial(@PathVariable("id") Long id){
        serialService.delete(id);
    }

    @PostMapping("/serials/search")
    public List<Serial> search (@RequestBody String query){
        return serialService.search(query);
    }



}
