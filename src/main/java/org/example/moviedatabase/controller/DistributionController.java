package org.example.moviedatabase.controller;

import jakarta.validation.Valid;
import org.example.moviedatabase.contract.DistributionRequest;
import org.example.moviedatabase.model.Distribution;
import org.example.moviedatabase.service.DistributionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DistributionController {
    private final DistributionService distributionService;

    public DistributionController(DistributionService distributionService) {
        this.distributionService = distributionService;
    }

    @GetMapping("/distributions")
    public List<Distribution> getDistributions() {
        return distributionService.list();
    }

    @PostMapping("/distributions")
    public ResponseEntity<?> postDistribution(@RequestBody @Valid DistributionRequest distribution) {
        try {
            var ret = distributionService.create(distribution);
            return ResponseEntity.ok(ret);
        } catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/distributions/{id}")
    public Distribution getDistributionById(@PathVariable("id") Long id) {
        return distributionService.read(id);
    }

    @PutMapping("/distributions")
    public Distribution putDistribution(@RequestBody @Valid DistributionRequest distribution) {
        return distributionService.update(distribution);
    }

    @DeleteMapping("/distributions/{id}")
    public void deleteDistribution(@PathVariable("id") Long id) {
        distributionService.delete(id);
    }

    @PostMapping("/distributions/search")
    public List<Distribution> search(@RequestBody String query){
        return distributionService.search(query);
    }




}
