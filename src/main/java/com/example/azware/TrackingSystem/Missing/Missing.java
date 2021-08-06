package com.example.azware.TrackingSystem.Missing;

import javax.persistence.*;

// Object representing a Missing Person Report
@Entity // Hibernate mapping
@Table  // Postgres table for missing reports
public class Missing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)     // Autogenerate missing report IDs
    private Long id;
    private String reporterName;
    private String name;
    private String description;

    public Missing(Long id, String reporterName, String name, String description) {
        this.id = id;
        this.reporterName = reporterName;
        this.name = name;
        this.description = description;
    }

    // Overload constructor. No ID
    public Missing(String reporterName, String name, String description) {
        this.reporterName = reporterName;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", reporter='" + reporterName + '\'' +
                ", missingPerson='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
