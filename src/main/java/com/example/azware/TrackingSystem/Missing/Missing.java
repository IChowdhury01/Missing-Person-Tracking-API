package com.example.azware.TrackingSystem.Missing;

import javax.persistence.*;

// Object representing a Missing Person Report
@Entity // Hibernate mapping
@Table  // Postgres table for missing reports
public class Missing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)     // Autogenerate missing report IDs
    private Long id;
    private String reporter;
    private String missingPerson;
    private String description;

    public Missing(Long id, String reporter, String missingPerson, String description) {
        this.id = id;
        this.reporter = reporter;
        this.missingPerson = missingPerson;
        this.description = description;
    }

    // Overload constructor. No ID
    public Missing(String reporter, String missingPerson, String description) {
        this.reporter = reporter;
        this.missingPerson = missingPerson;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getMissingPerson() {
        return missingPerson;
    }

    public void setMissingPerson(String missingPerson) {
        this.missingPerson = missingPerson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MissingReport{" +
                "id=" + id +
                ", reporter='" + reporter + '\'' +
                ", missingPerson='" + missingPerson + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
