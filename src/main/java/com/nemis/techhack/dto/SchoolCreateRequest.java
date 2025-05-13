package com.nemis.techhack.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class SchoolCreateRequest {
    private String schoolCode;
    private String schoolName;
    private String admissionNumber;
    private LocalDate enrollmentDate;
    private String currentStatus;
    private List<CompetencyCreateRequest> competencies;
}

