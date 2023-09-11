package com.example.humanresourcesdepartment.service;

import com.example.humanresourcesdepartment.dto.EmployeeDto;
import com.example.humanresourcesdepartment.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmloyee();

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    void deleteEmployeeById(Long id);

    EmployeeDto getEmployeeByEmail(String email);

    List<EmployeeDto> getEmployeeByPosition(String position);

    List<EmployeeDto> getEmployeeByStatus(boolean status);

    List<EmployeeDto> getEmployeeByNameContaining(String keyword);

    List<EmployeeDto> getEmployeeByBirthDayBetween(Date start, Date end);
}
