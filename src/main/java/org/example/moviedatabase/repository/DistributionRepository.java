package org.example.moviedatabase.repository;

import org.example.moviedatabase.model.Distribution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistributionRepository extends JpaRepository<Distribution, Long> {
    List<Distribution> findDistributionByNameContainingIgnoreCase(String name);

}
