package com.example.azware.TrackingSystem.Missing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Presentation layer. Class for establishing API endpoints for presenting data.
@RestController
@RequestMapping(path = "/api/missing")
public class MissingController {
    private final MissingService missingService;

    @Autowired  // Dependency injection: automatically instantiate missingService when assigning constructor
    public MissingController(MissingService missingService) {
        this.missingService = missingService;
    }

    // View all missing person reports
    @GetMapping
    public List<Missing> getMissingReports() {
        return missingService.getMissingReports();
    }

    // Add missing person
    @PostMapping
    public void addMissingReport(@RequestBody Missing missingReport) {  // Convert POST request body to Missing obj
        missingService.addMissingReport(missingReport);
    }
}
