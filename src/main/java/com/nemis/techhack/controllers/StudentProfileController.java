package com.nemis.techhack.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nemis.techhack.interfaces.IStudentProfile;
import com.nemis.techhack.model.StudentProfile;
import com.nemis.techhack.services.StudentProfileService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Profile API", description = "Operations related to student profiles")
@RequiredArgsConstructor
public class StudentProfileController {

    // Inject the service
    private final IStudentProfile studentProfileService;
    //Define endpoints for CRUD operations
    @PostMapping("/student-profile")
    public ResponseEntity<?> createStudentProfile(@RequestBody StudentProfile studentProfile) {
        return studentProfileService.createStudentProfile(studentProfile);
    }

    @GetMapping("/student-profile/{uniqueId}")
    public ResponseEntity<?> readStudentProfile(@PathVariable String uniqueId) {
        return studentProfileService.readStudentProfile(uniqueId);
    }

    @PatchMapping("/student-profile")
    public ResponseEntity<?> updateStudentProfile(@RequestBody StudentProfile studentProfile) {
        return studentProfileService.updateStudentProfile(studentProfile);
    }

    @GetMapping("/student-profiles")
    public List<StudentProfile> getAllStudentProfiles() {
        return studentProfileService.getAllStudentProfiles();
    }
}
