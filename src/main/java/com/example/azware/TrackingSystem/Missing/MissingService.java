package com.example.azware.TrackingSystem.Missing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service layer: Class for business logic using db data.
@Service
public class MissingService {
    private final MissingRepository missingRepository;

    @Autowired  // Dependency injection. Service uses repository without instantiating obj
    public MissingService(MissingRepository missingRepository) {
        this.missingRepository = missingRepository;
    }

    // Get all missing person reports
    public List<Missing> getMissingReports() {
        return missingRepository.findAll();
    }
}
