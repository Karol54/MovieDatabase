package org.example.moviedatabase.service;

import org.example.moviedatabase.contract.DistributionRequest;
import org.example.moviedatabase.model.Distribution;


import java.util.List;

public interface DistributionService {
    Distribution create(DistributionRequest distribution);
    Distribution read(Long id);
    Distribution update(DistributionRequest distribution);
    void delete(Long id);
    List<Distribution> list();
    List<Distribution> search(String query);
}
