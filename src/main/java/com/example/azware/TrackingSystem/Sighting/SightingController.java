package com.example.azware.TrackingSystem.Sighting;

import com.example.azware.TrackingSystem.Missing.Missing;
import com.example.azware.TrackingSystem.Missing.MissingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping(
            path = "{id}/image/upload", // api/sightings/{sightingID}/image/upload
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    // Save uploaded photo to disk (src/main/resources/images), and update filepath in DB.
    // Method extracts id from path and file from POST request
    public void uploadSightingImg(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) throws IOException {
        sightingService.uploadSightingImg(id, file);
    }

    @PutMapping(path = "{id}")  // api/sightings/{sightingID}
    // Update reporter name or comments of a specific sighting report.
    public void updateSighting(@PathVariable("id") Long id,
                               @RequestParam(required = false) String reporterName,
                               @RequestParam(required = false) String comments) {
        sightingService.updateSighting(id, reporterName, comments);
    }
}
