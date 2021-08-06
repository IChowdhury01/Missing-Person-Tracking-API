package com.example.azware.TrackingSystem.Missing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service layer: Class for business logic using db data.
@Service
public class MissingService {
    private final MissingRepository missingRepository;

    @Autowired  // Dependency injection. Service uses repository without instantiating obj
    public MissingService(MissingRepository missingRepository) {
        this.missingRepository = missingRepository;
    }

    public void addMissingReport(Missing missingReport) {
        String inputName = missingReport.getName();
        // Search DB for missing person name. If already in DB, don't add again.
        Optional<Missing> missingReportDB = missingRepository.findMissingByName(inputName);
        if(missingReportDB.isPresent()) {
            throw new IllegalStateException("This person has already been added to the database.");
        }
        missingRepository.save(missingReport);
    }

    // Get all missing person reports
    public List<Missing> getMissingReports() {
        return missingRepository.findAll();
    }
}
