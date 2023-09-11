package com.example.humanresourcesdepartment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoRestDto {

    private Long id;
    private String reason;
    private Date startDay;
    private Date endDay;
    private String status;
    private Date createdDay;
    private Date modifiedDay;
    private EmployeeDto employeeDto;
    private EmployeeDto leaderDto;

}
