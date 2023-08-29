package com.example.humanresourcesdepartment.service;

import com.example.humanresourcesdepartment.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmloyee();

    Employee getEmployeeById(Long id);

    Employee saveEmployee(Employee employee);

    void deleteEmployeeById(Long id);

    Employee getEmployeeByEmail(String email);

    List<Employee> getEmployeeByPosition(String position);

    List<Employee> getEmployeeByStatus(boolean status);

    List<Employee> getEmployeeByNameContaining(String keyword);

    List<Employee> getEmployeeByBirthDayBetween(Date start, Date end);
}
