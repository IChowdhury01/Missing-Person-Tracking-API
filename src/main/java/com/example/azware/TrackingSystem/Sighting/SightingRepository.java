package com.example.azware.TrackingSystem.Sighting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SightingRepository extends JpaRepository<Sighting, Long> {
    Optional<Sighting> findSightingById(Long id);
}
