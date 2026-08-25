package com.agripulse.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fertilizer_request")
public class FertilizerRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String farmName;

    @Column(nullable = false, unique = true)
    private String contactNumber;    // reliable identifier — farmName alone is not unique

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String fertilizerType;   // e.g. "Urea", "NPK", "Compost"

    @Column(nullable = false)
    private int requestedBags;       // knapsack "weight"

    @Column(nullable = false)
    private double benefitScore;     // knapsack "value"

    @Column(nullable = false)
    private String urgencyLevel = "MEDIUM"; // LOW, MEDIUM, HIGH

    @Column(nullable = false)
    private String status = "PENDING";      // PENDING, ALLOCATED, REJECTED

    @Column
    private int allocatedBags = 0;   // filled in after DP runs (0 or full requestedBags)

    @Column(nullable = false)
    private LocalDateTime requestDate = LocalDateTime.now();

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public FertilizerRequest() {
    }

    public FertilizerRequest(String farmName, String contactNumber, String region, String fertilizerType,
                              int requestedBags, double benefitScore, String urgencyLevel) {
        this.farmName = farmName;
        this.contactNumber = contactNumber;
        this.region = region;
        this.fertilizerType = fertilizerType;
        this.requestedBags = requestedBags;
        this.benefitScore = benefitScore;
        this.urgencyLevel = urgencyLevel;
        this.status = "PENDING";
        this.requestDate = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFertilizerType() {
        return fertilizerType;
    }

    public void setFertilizerType(String fertilizerType) {
        this.fertilizerType = fertilizerType;
    }

    public int getRequestedBags() {
        return requestedBags;
    }

    public void setRequestedBags(int requestedBags) {
        this.requestedBags = requestedBags;
    }

    public double getBenefitScore() {
        return benefitScore;
    }

    public void setBenefitScore(double benefitScore) {
        this.benefitScore = benefitScore;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAllocatedBags() {
        return allocatedBags;
    }

    public void setAllocatedBags(int allocatedBags) {
        this.allocatedBags = allocatedBags;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}