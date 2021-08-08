package com.example.azware.TrackingSystem.Sighting;

import javax.persistence.*;

// Sighting Report
@Entity
@Table
public class Sighting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reporterName;
    private String imgPath;   // Uploaded image stored as url in API
    private String comments;

    public Sighting() {
    }

    public Sighting(Long sightingID, String reporterName, String imgPath, String comments) {
        this.id = sightingID;
        this.reporterName = reporterName;
        this.imgPath = imgPath;
        this.comments = comments;
    }

    // No ID
    public Sighting(String reporterName, String imgPath, String comments) {
        this.reporterName = reporterName;
        this.imgPath = imgPath;
        this.comments = comments;
    }

    // No image input
    public Sighting(String reporterName, String comments) {
        this.reporterName = reporterName;
        this.comments = comments;
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Sighting{" +
                "id=" + id +
                ", reporterName='" + reporterName + '\'' +
                ", imgLink='" + imgPath + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
