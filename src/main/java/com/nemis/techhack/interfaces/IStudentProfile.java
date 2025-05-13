package com.nemis.techhack.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nemis.techhack.dto.CompetencyCreateRequest;
import com.nemis.techhack.dto.SchoolCreateRequest;
import com.nemis.techhack.model.StudentProfile;

public interface IStudentProfile {
    // Define methods for CRUD operations
    ResponseEntity<?> createStudentProfile(StudentProfile studentProfile);
    ResponseEntity<?> readStudentProfile(String uniqueId);
    //Add competency to student profile
    ResponseEntity<?> addCompetencyToSchool(String upi, Long schoolId, CompetencyCreateRequest request);
    // Add school to student
    ResponseEntity<?> addSchoolToStudent(String upi, SchoolCreateRequest request);
    // Get all student profiles
    List<StudentProfile> getAllStudentProfiles();


}
