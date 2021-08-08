package com.example.azware.TrackingSystem.Sighting;

import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        String comments = sighting.getComments();
        String reporterName = sighting.getReporterName();
        Long id = sighting.getId();

        // Check if sighting already exists
        Optional<Sighting> sightingOp = sightingRepository.findSightingById(id);
        if(sightingOp.isPresent()) {
            throw new IllegalStateException("Sighting #" + id + " has already been reported. To update it, send a PUT request.");
        }

        // Check if essential fields are missing
        if(comments == null || reporterName == null) {
            throw new IllegalStateException("Missing fields. Must specify the reporter's name and a description of the sighting.");
        }

        // Set default image path to null
        sighting.setImgPath(null);

        sightingRepository.save(sighting);
    }

    public void uploadSightingImg(Long id, MultipartFile file) throws IOException {
        // Check if sighting ID exists in DB
        Optional<Sighting> sighting = sightingRepository.findSightingById(id);
        if (!sighting.isPresent()) {
            throw new IllegalStateException("Sighting #" + id + " has not been reported yet. You must report a sighting before uploading a photo for it.");
        }
        // Check if file is not empty
        if(file.isEmpty()) throw new IllegalStateException(file.getOriginalFilename() + " is an empty file.");

        // Check if file is an image
        Set<String> acceptedTypes = new HashSet<>();
        acceptedTypes.add(String.valueOf(ContentType.IMAGE_JPEG));
        acceptedTypes.add(String.valueOf(ContentType.IMAGE_PNG));

        String fileType = file.getContentType();
        if(!acceptedTypes.contains(fileType)) {
            throw new IllegalStateException("File must be a JPEG or PNG image.");
        }

        // Assemble path.
        String folder = "./src/main/resources/images/";
        String filename = String.format("sighting-%s-%s", id, file.getOriginalFilename());
        Path path = Paths.get(folder + filename);

        // Delete old image, if there is one.
        Sighting s = sighting.get();
        String oldPath = s.getImgPath();
        if (oldPath != null) {
            Files.deleteIfExists(Paths.get(oldPath));
        }

        // Save new image to disk.
        byte[] imgData = file.getBytes();
        Files.write(path, imgData);

        // Update sighting report in database with new image path.
        s.setImgPath(folder + filename);
        sightingRepository.save(s);
    }

    public void updateSighting(Long id, String reporterName, String comments) {
        Optional<Sighting> sighting = sightingRepository.findSightingById(id);
        if(!sighting.isPresent()) throw new IllegalStateException("Sighting #" + id + " does not exist.");

        Sighting s = sighting.get();
        if(reporterName != null) {
            s.setReporterName(reporterName);
        }
        if(comments != null) {
            s.setComments(comments);
        }
        sightingRepository.save(s);
    }
}
