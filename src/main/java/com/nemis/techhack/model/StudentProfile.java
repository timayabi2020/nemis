package com.nemis.techhack.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String upi;

    @Embedded
    private FullName fullName;

    private LocalDate dateOfBirth;
    private String gender;
    private String nationality;
    private String birthCertificateNumber;

    @Embedded
    private SpecialNeeds specialNeeds;

    @Embedded
    private Location location;

    @Embedded
    private Contact contact;

    @Embedded
    private ParentGuardian parentGuardian;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SchoolRecord> schoolHistory;
}

@Embeddable
@Data
class FullName {
    private String firstName;
    private String middleName;
    private String lastName;
}

@Embeddable
@Data
class SpecialNeeds {
    private boolean hasSpecialNeeds;
    private String type;
}

@Embeddable
@Data
class Location {
    private String county;
    private String subCounty;
    private String ward;
    private String village;
    private double distanceToSchoolKm;
}

@Embeddable
@Data
class Contact {
    private String address;
    private String nearestHealthFacility;
}

@Embeddable
@Data
class ParentGuardian {
    private String name;
    private String relationship;
    private String nationalId;
    private String contactPhone;
    private String occupation;
    private String incomeLevel;
}

@Entity
@Data
class SchoolRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String schoolCode;
    private String schoolName;
    private String admissionNumber;
    private String gradeLevel;
    private LocalDate enrollmentDate;
    private String currentStatus;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LearningArea> learningAreas;
}

@Entity
@Data
class LearningArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Competency> competencies;
}

@Entity
@Data
class Competency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String competencyCode;
    private String description;
    private String achievementLevel; // e.g., Emerging, Developing, Proficient
    private LocalDate assessmentDate;
    private String assessedBy;
    // Optionally add: evidenceFiles, remediationPlan
}
