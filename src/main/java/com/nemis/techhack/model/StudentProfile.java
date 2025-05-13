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


