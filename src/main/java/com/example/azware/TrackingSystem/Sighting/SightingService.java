package com.example.azware.TrackingSystem.Sighting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SightingService {
    private final SightingRepository sightingRepository;

    @Autowired
    public SightingService(SightingRepository sightingRepository) {
        this.sightingRepository = sightingRepository;
    }

    // Get all sighting reports.
    public List<Sighting> getSightings() {
        return sightingRepository.findAll();
    }

    public void addSighting(Sighting sighting) {
        sightingRepository.save(sighting);
    }
}
