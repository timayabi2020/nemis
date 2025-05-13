package com.nemis.techhack.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nemis.techhack.dto.CompetencyCreateRequest;
import com.nemis.techhack.dto.SchoolCreateRequest;
import com.nemis.techhack.interfaces.IStudentProfile;
import com.nemis.techhack.model.Competency;
import com.nemis.techhack.model.SchoolRecord;
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
    public ResponseEntity<?> addCompetencyToSchool(String upi, Long schoolId, CompetencyCreateRequest request) {
        StudentProfile student = studentProfileRepository.findByUpi(upi)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        SchoolRecord school = student.getSchoolHistory().stream()
                .filter(s -> s.getId().equals(schoolId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("School not found"));

        Competency newCompetency = new Competency();
        newCompetency.setCompetencyCode(request.getCompetencyCode());
        newCompetency.setCompetencyName(request.getCompetencyName());
        newCompetency.setDescription(request.getDescription());
        newCompetency.setGradeLevel(request.getGradeLevel());
        newCompetency.setAchievementLevel(request.getAchievementLevel());
        newCompetency.setAssessmentDate(request.getAssessmentDate());
        newCompetency.setAssessedBy(request.getAssessedBy());
        newCompetency.setTscno(request.getTscno());

        school.getCompetencies().add(newCompetency);
        studentProfileRepository.save(student);

        return ResponseEntity.ok("Competency added successfully.");
    }

    @Override
    public ResponseEntity<?> addSchoolToStudent(String upi, SchoolCreateRequest request) {
        StudentProfile student = studentProfileRepository.findByUpi(upi)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        SchoolRecord school = new SchoolRecord();
        school.setSchoolCode(request.getSchoolCode());
        school.setSchoolName(request.getSchoolName());
        school.setAdmissionNumber(request.getAdmissionNumber());
        school.setEnrollmentDate(request.getEnrollmentDate());
        school.setCurrentStatus(request.getCurrentStatus());

        if (request.getCompetencies() != null) {
            List<Competency> competencyList = request.getCompetencies().stream().map(c -> {
                Competency comp = new Competency();
                comp.setCompetencyCode(c.getCompetencyCode());
                comp.setCompetencyName(c.getCompetencyName());
                comp.setDescription(c.getDescription());
                comp.setGradeLevel(c.getGradeLevel());
                comp.setAchievementLevel(c.getAchievementLevel());
                comp.setAssessmentDate(c.getAssessmentDate());
                comp.setAssessedBy(c.getAssessedBy());
                comp.setTscno(c.getTscno());
                return comp;
            }).toList();

            school.setCompetencies(competencyList);
        }

        student.getSchoolHistory().add(school);
        studentProfileRepository.save(student);

        return ResponseEntity.ok("School added successfully.");
    }

    @Override
    public List<StudentProfile> getAllStudentProfiles() {
        return studentProfileRepository.findAll();
    }

}
