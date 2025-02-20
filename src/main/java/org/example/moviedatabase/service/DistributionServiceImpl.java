package org.example.moviedatabase.service;

import org.example.moviedatabase.contract.DistributionRequest;
import org.example.moviedatabase.exception.RecordNotFoundException;
import org.example.moviedatabase.model.Distribution;
import org.example.moviedatabase.repository.DistributionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DistributionServiceImpl implements DistributionService{
    private final DistributionRepository distributionRepository;

    public DistributionServiceImpl(DistributionRepository distributionRepository) {
        this.distributionRepository = distributionRepository;
    }

    @Override
    public Distribution create(DistributionRequest distribution) {
        var toDb = new Distribution(distribution);
        toDb.setCreated(LocalDateTime.now());
        return distributionRepository.save(toDb);
    }

    @Override
    public Distribution read(Long id) {
        if (id == null){
            throw new RecordNotFoundException(id, "distribution");
        }
        return distributionRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id, "distribution"));
    }

    @Override
    public Distribution update(DistributionRequest distribution) {
        var fromDb = read(distribution.getId());
        if (fromDb == null){
            throw new RecordNotFoundException(distribution.getId(), "distribution");
        }
        fromDb.setName(distribution.getName());
        fromDb.setFoundedYear(distribution.getFoundedYear());
        fromDb.setLocation(distribution.getLocation());
        fromDb.setUpdated(distribution.getUpdated());
        var ret = distributionRepository.save(fromDb);

        return ret;
    }

    @Override
    public void delete(Long id) {
        var fromDb = read(id);
        if (fromDb == null){
            throw new RecordNotFoundException(id, "distribution");
        }
        distributionRepository.delete(fromDb);
    }

    @Override
    public List<Distribution> list() {
        return distributionRepository.findAll();
    }

    @Override
    public List<Distribution> search(String query) {
        return distributionRepository.findDistributionByNameContainingIgnoreCase(query);
    }
}
