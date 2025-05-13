package com.nemis.techhack.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nemis.techhack.model.StudentProfile;

public interface StudentProfileRepository  extends JpaRepository<StudentProfile, Long> {
    Optional<StudentProfile> findByUpi(String upi);
    List<StudentProfile> findByLocation(String location);
    List<StudentProfile> findBySchool(String school);
    List<StudentProfile> findByParentGuardian(String parentGuardian);
    List<StudentProfile> findByDateOfBirth(LocalDate dateOfBirth);

}
