package com.example.quanlynhansu.service.impl;

import com.example.quanlynhansu.model.Employee;
import com.example.quanlynhansu.repository.EmployeeRepository;
import com.example.quanlynhansu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmloyee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public List<Employee> getEmployeeByPosition(String position) {
        return employeeRepository.findByPosition(position);
    }

    @Override
    public List<Employee> getEmployeeByStatus(boolean status) {
        return employeeRepository.findByStatusEmployee(status);
    }

    @Override
    public List<Employee> getEmployeeByNameContaining(String keyword) {
        return employeeRepository.findByNameContaining(keyword);
    }

    @Override
    public List<Employee> getEmployeeByBirthDayBetween(Date start, Date end) {
        return employeeRepository.findByBirthDayBetween(start, end);
    }
}

