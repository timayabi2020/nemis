package com.nemis.techhack.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nemis.techhack.model.StudentProfile;

public interface IStudentProfile {
    // Define methods for CRUD operations
    ResponseEntity<?> createStudentProfile(StudentProfile studentProfile);
    ResponseEntity<?> readStudentProfile(String uniqueId);
    ResponseEntity<?> updateStudentProfile(StudentProfile studentProfile);

    // Get all student profiles
    List<StudentProfile> getAllStudentProfiles();


}
