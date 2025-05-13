package com.nemis.techhack.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nemis.techhack.interfaces.IStudentProfile;
import com.nemis.techhack.model.StudentProfile;
import com.nemis.techhack.repositories.StudentProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentProfileService implements IStudentProfile {
    // Inject the repository
    private final StudentProfileRepository studentProfileRepository;


    @Override
    public ResponseEntity<?> createStudentProfile(StudentProfile studentProfile) {
        // Check if the UPI already exists
        if (studentProfileRepository.findByUpi(studentProfile.getUpi()).isPresent()) {
            return ResponseEntity.badRequest().body("UPI already exists");
        }
        // Save the student profile
        studentProfileRepository.save(studentProfile);
        return ResponseEntity.ok("Student profile created successfully");
    }

    @Override
    public ResponseEntity<?> readStudentProfile(String uniqueId) {
        return studentProfileRepository.findByUpi(uniqueId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> updateStudentProfile(StudentProfile studentProfile) {
        // Check if the student profile exists
        if (!studentProfileRepository.findByUpi(studentProfile.getUpi()).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        // Update the student profile

        studentProfileRepository.save(studentProfile);
        return ResponseEntity.ok("Student profile updated successfully");
    }

    @Override
    public List<StudentProfile> getAllStudentProfiles() {
        return studentProfileRepository.findAll();
    }

}
