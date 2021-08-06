package com.example.azware.TrackingSystem.Missing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Data access layer. Interface for accessing data in db.
@Repository
public interface MissingRepository extends JpaRepository<Missing, Long> {
    // Inherited inbuilt JpaRepository methods. Core CRUD data access operations.

    // Find missing person by name. If name exists in DB -> optional.isPresent() = true
    Optional<Missing> findMissingByName(String name);
}
