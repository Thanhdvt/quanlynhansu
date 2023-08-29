package com.example.humanresourcesdepartment.service.impl;

import com.example.humanresourcesdepartment.model.Employee;
import com.example.humanresourcesdepartment.model.WorkDay;
import com.example.humanresourcesdepartment.repository.WorkDayRepository;
import com.example.humanresourcesdepartment.service.WorkDayService;
import org.springframework.stereotype.Service;

@Service
public class WorkDayServiceImpl implements WorkDayService {

    private WorkDayRepository workDayRepository;
    WorkDayServiceImpl(WorkDayRepository workDayRepository){
        this.workDayRepository = workDayRepository;
    }

    @Override
    public WorkDay getWorkDayById(Long id) {
        return workDayRepository.findById(id).orElse(null);
    }

    @Override
    public WorkDay saveWorkDay(WorkDay workDay) {
        return workDayRepository.save(workDay);
    }

    @Override
    public void deleteWorkDay(Long id) {
        workDayRepository.deleteById(id);
    }

    @Override
    public int countNumberDayHasWork(Employee employee, int month) {
        return workDayRepository.countNumberDayHasWork(employee, month);
    }

    @Override
    public double calculate_Salary(Employee employee, int month) {
        int numberDayHasWork = workDayRepository.countNumberDayHasWork(employee, month);
        double salary = employee.getSalary();
        return numberDayHasWork * salary;
    }


}
