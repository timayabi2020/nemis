package com.nemis.techhack.model;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Competency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String competencyCode;
    private String competencyName;
    private String description;
    private String gradeLevel;
    private String achievementLevel; // e.g., Emerging, Developing, Proficient
    private LocalDate assessmentDate;
    private String assessedBy;
    private String tscno;
    // Optionally add: evidenceFiles, remediationPlan
}