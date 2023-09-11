package com.example.humanresourcesdepartment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkDayDto {

    private Long id;
    private Long employeeId;
    private LocalDate date;
    private Boolean hasWork;

}
