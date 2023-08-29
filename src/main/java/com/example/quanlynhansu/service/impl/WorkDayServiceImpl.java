package com.example.quanlynhansu.service.impl;

import com.example.quanlynhansu.model.WorkDay;
import com.example.quanlynhansu.model.Employee;
import com.example.quanlynhansu.repository.WorkDayRepository;
import com.example.quanlynhansu.service.WorkDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkDayServiceImpl implements WorkDayService {

    @Autowired
    private WorkDayRepository workDayRepository;

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
