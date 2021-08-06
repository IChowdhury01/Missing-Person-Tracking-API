package com.example.azware.TrackingSystem.Sighting;

import javax.persistence.*;
import java.util.Arrays;

// Sighting Report
@Entity
@Table
public class Sighting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reporterName;
    private byte[] image;   // Image stored as byte array
    private String comments;

    public Sighting(Long id, String reporterName, byte[] image, String comments) {
        this.id = id;
        this.reporterName = reporterName;
        this.image = image;
        this.comments = comments;
    }

    // No ID
    public Sighting(String reporterName, byte[] image, String comments) {
        this.reporterName = reporterName;
        this.image = image;
        this.comments = comments;
    }

    // No ID or image input
    public Sighting(String reporterName, String comments) {
        this.reporterName = reporterName;
        this.comments = comments;
        this.image = new byte[0];
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "SightingReport{" +
                "id=" + id +
                ", reporter='" + reporterName + '\'' +
                ", image=" + Arrays.toString(image) +
                ", comments='" + comments + '\'' +
                '}';
    }
}
