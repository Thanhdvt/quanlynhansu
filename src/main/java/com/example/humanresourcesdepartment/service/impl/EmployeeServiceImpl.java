package com.example.humanresourcesdepartment.service.impl;

import com.example.humanresourcesdepartment.model.Employee;
import com.example.humanresourcesdepartment.repository.EmployeeRepository;
import com.example.humanresourcesdepartment.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    EmployeeServiceImpl (EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

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

