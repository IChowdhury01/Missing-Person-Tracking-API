package com.example.azware.TrackingSystem.Missing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Data access layer. Interface for accessing data in db.
@Repository
public interface MissingRepository extends JpaRepository<Missing, Long> {
    // Inherited inbuilt JpaRepository methods. Core CRUD data access operations.
}
