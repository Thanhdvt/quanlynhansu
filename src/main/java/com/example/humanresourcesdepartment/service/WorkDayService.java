package com.example.humanresourcesdepartment.service;

import com.example.humanresourcesdepartment.model.WorkDay;
import com.example.humanresourcesdepartment.model.Employee;

public interface WorkDayService {

    WorkDay getWorkDayById(Long id);

    WorkDay saveWorkDay(WorkDay workDay);

    void deleteWorkDay(Long id);

    int countNumberDayHasWork(Employee employee, int month);

    double calculate_Salary(Employee employee, int month);
}
