package com.example.azware.TrackingSystem.Sighting;

import com.example.azware.TrackingSystem.Missing.Missing;
import com.example.azware.TrackingSystem.Missing.MissingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void addSighting(@RequestBody Sighting sighting) {
        sightingService.addSighting(sighting);
    }
}
