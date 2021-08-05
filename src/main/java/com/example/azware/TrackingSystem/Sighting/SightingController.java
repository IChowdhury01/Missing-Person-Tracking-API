package com.example.azware.TrackingSystem.Sighting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/sightings")
public class SightingController {
    private final SightingService sightingService;

    @Autowired
    public SightingController(SightingService sightingService) {
        this.sightingService = sightingService;
    }

    // View all sighting reports
    @GetMapping
    public List<Sighting> getSightings() {
        return sightingService.getSightings();
    }
}
