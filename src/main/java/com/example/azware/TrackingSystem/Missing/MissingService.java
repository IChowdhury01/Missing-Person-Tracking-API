package com.example.azware.TrackingSystem.Missing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        // Get object fields from HTTP request
        String inputName = missingReport.getName();
        String reporterName = missingReport.getReporterName();
        String description = missingReport.getDescription();

        // Check for mandatory fields.
        if(inputName == null || reporterName == null || description == null) {
            throw new IllegalStateException("Missing fields. Must specify missing person and reporter names, along with a description of the missing person.");
        }

        // Search DB for missing person name. If already in DB, don't add again.
        Optional<Missing> missingReportDB = missingRepository.findMissingByName(inputName);
        if(missingReportDB.isPresent()) {
            throw new IllegalStateException(inputName + " has already been reported missing.");
        }

        // Add object to DB
        missingRepository.save(missingReport);
    }

    // Get all missing person reports
    public List<Missing> getMissingReports() {
        return missingRepository.findAll();
    }

    public void updateMissingReport(Long id, String reporterName, String name, String description) {
        Optional<Missing> missingReport = missingRepository.findMissingById(id);
        if(!missingReport.isPresent()) {
            throw new IllegalStateException("Missing person report #" + id + " does not exist.");
        }
        Missing m = missingReport.get();
        if(name != null) {
            if(missingRepository.findMissingByName(name).isPresent()) {
                throw new IllegalStateException(name + " has already been reported missing.");
            } else {
                m.setName(name);
            }
        }
        if(reporterName != null) {
            m.setReporterName(reporterName);
        }
        if(description != null) {
            m.setDescription(description);
        }
        missingRepository.save(m);
    }
}
