package com.waymark.assessment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class VerificationRecord {
    @Id
    private long id;
    private String idNumber;
    private String fullName;
    private String status;
    private Timestamp createdAt;
    private int confidence;
    private String rejectionReason;
}
