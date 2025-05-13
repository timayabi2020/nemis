package com.nemis.techhack.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CompetencyCreateRequest {
    private String competencyCode;
    private String competencyName;
    private String description;
    private String gradeLevel;
    private String achievementLevel;
    private LocalDate assessmentDate;
    private String assessedBy;
    private String tscno;
}
