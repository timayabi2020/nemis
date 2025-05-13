package com.nemis.techhack.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class SchoolRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String schoolCode;
    private String schoolName;
    private String admissionNumber;
    private LocalDate enrollmentDate;
    private LocalDate graduationDate;
    private LocalDate endDate;
    private String currentStatus;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Competency> competencies;
}
