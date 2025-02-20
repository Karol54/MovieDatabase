package org.example.moviedatabase.contract;

import java.time.LocalDateTime;

public class DistributionRequest {
    private Long id;
    private String name;
    private int foundedYear;
    private String location;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }
}
