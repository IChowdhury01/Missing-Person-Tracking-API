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
    private String reporter;
    private byte[] image;   // Image stored as byte array
    private String comments;

    public Sighting(Long id, String reporter, byte[] image, String comments) {
        this.id = id;
        this.reporter = reporter;
        this.image = image;
        this.comments = comments;
    }

    // No ID
    public Sighting(String reporter, byte[] image, String comments) {
        this.reporter = reporter;
        this.image = image;
        this.comments = comments;
    }

    // No ID or image input
    public Sighting(String reporter, String comments) {
        this.reporter = reporter;
        this.comments = comments;
        this.image = new byte[0];
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
                ", reporter='" + reporter + '\'' +
                ", image=" + Arrays.toString(image) +
                ", comments='" + comments + '\'' +
                '}';
    }
}
