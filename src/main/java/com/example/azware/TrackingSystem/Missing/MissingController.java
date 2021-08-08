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
    // Take in the body of the HTTP POST request (JSON), deserialize to Missing object
    public void addMissingReport(@RequestBody Missing missingReport) {
        missingService.addMissingReport(missingReport);
    }

    @PutMapping(path = "{id}")  //api/missing/{id}
    // Update field values for missing person report with the given ID
    public void updateMissingReport(@PathVariable("id") Long id,
                                    @RequestParam(required = false) String reporterName,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) String description) {
        missingService.updateMissingReport(id, reporterName, name, description);
    }
}
