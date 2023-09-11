package com.example.humanresourcesdepartment.service.impl;

import com.example.humanresourcesdepartment.dto.EmployeeDto;
import com.example.humanresourcesdepartment.dto.WorkDayDto;
import com.example.humanresourcesdepartment.model.Employee;
import com.example.humanresourcesdepartment.repository.EmployeeRepository;
import com.example.humanresourcesdepartment.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper = new ModelMapper();
    EmployeeServiceImpl (EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDto> getAllEmloyee() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
        return employeeDtos;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return modelMapper.map(employeeRepository.findById(id).orElse(null), EmployeeDto.class);
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        return modelMapper.map(employeeRepository.save(employee), EmployeeDto.class);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDto getEmployeeByEmail(String email) {
        return modelMapper.map(employeeRepository.findByEmail(email), EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getEmployeeByPosition(String position) {

        List<Employee> employees = employeeRepository.findByPosition(position);
        List<EmployeeDto> employeeDtos = employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
        return employeeDtos;
    }

    @Override
    public List<EmployeeDto> getEmployeeByStatus(boolean status) {
        List<Employee> employees = employeeRepository.findByStatusEmployee(status);
        List<EmployeeDto> employeeDtos = employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
        return employeeDtos;
    }

    @Override
    public List<EmployeeDto> getEmployeeByNameContaining(String keyword) {
        List<Employee> employees = employeeRepository.findByNameContaining(keyword);
        List<EmployeeDto> employeeDtos = employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
        return employeeDtos;
    }

    @Override
    public List<EmployeeDto> getEmployeeByBirthDayBetween(Date start, Date end) {
        List<Employee> employees = employeeRepository.findByBirthDayBetween(start, end);
        List<EmployeeDto> employeeDtos = employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
        return employeeDtos;
    }
}

