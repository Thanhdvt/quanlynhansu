package com.example.humanresourcesdepartment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String name;
    private Date birthDay;
    private String gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String position;
    private boolean statusEmployee;
    private double salary;

}
