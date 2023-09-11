package com.example.humanresourcesdepartment.service.impl;

import com.example.humanresourcesdepartment.dto.EmployeeDto;
import com.example.humanresourcesdepartment.dto.WorkDayDto;
import com.example.humanresourcesdepartment.model.Employee;
import com.example.humanresourcesdepartment.model.WorkDay;
import com.example.humanresourcesdepartment.repository.WorkDayRepository;
import com.example.humanresourcesdepartment.service.WorkDayService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class WorkDayServiceImpl implements WorkDayService {

    private WorkDayRepository workDayRepository;
    private ModelMapper modelMapper = new ModelMapper();
    WorkDayServiceImpl(WorkDayRepository workDayRepository){
        this.workDayRepository = workDayRepository;
    }

    @Override
    public WorkDayDto getWorkDayById(Long id) {
        return modelMapper.map(workDayRepository.findById(id).orElse(null), WorkDayDto.class);
    }

    @Override
    public WorkDayDto saveWorkDay(WorkDayDto workDayDto) {
        WorkDay workDay = modelMapper.map(workDayDto, WorkDay.class);
        return modelMapper.map(workDayRepository.save(workDay), WorkDayDto.class);
    }

    @Override
    public void deleteWorkDay(Long id) {
        workDayRepository.deleteById(id);
    }

    @Override
    public int countNumberDayHasWork(EmployeeDto employeeDto, int month) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        return workDayRepository.countNumberDayHasWork(employee, month);
    }

    @Override
    public double calculate_Salary(EmployeeDto employeeDto, int month) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        int numberDayHasWork = workDayRepository.countNumberDayHasWork(employee, month);
        double salary = employee.getSalary();
        return numberDayHasWork * salary;
    }


}
