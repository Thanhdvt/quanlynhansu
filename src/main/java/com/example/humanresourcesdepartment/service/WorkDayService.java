package com.example.humanresourcesdepartment.service;

import com.example.humanresourcesdepartment.dto.EmployeeDto;
import com.example.humanresourcesdepartment.dto.WorkDayDto;
import com.example.humanresourcesdepartment.model.WorkDay;
import com.example.humanresourcesdepartment.model.Employee;

public interface WorkDayService {

    WorkDayDto getWorkDayById(Long id);

    WorkDayDto saveWorkDay(WorkDayDto workDayDto);

    void deleteWorkDay(Long id);

    int countNumberDayHasWork(EmployeeDto employeeDto, int month);

    double calculate_Salary(EmployeeDto employeeDto, int month);
}
