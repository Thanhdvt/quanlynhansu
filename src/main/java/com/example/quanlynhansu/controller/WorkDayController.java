package com.example.quanlynhansu.controller;

import com.example.quanlynhansu.model.WorkDay;
import com.example.quanlynhansu.model.Employee;
import com.example.quanlynhansu.service.WorkDayService;
import com.example.quanlynhansu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/work-day")
public class WorkDayController {

    @Autowired
    private WorkDayService workDayService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<WorkDay> getWorkDayById(@PathVariable Long id) {
        WorkDay workDay = workDayService.getWorkDayById(id);
        if (workDay == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(workDay);
    }

    @PostMapping
    public ResponseEntity<WorkDay> saveWorkDay(@RequestBody WorkDay workDay) {
        WorkDay savedWorkDay = workDayService.saveWorkDay(workDay);
        return ResponseEntity.created(URI.create("/api/work-day/" + savedWorkDay.getId())).body(savedWorkDay);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkDay(@PathVariable Long id) {
        workDayService.deleteWorkDay(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/calculate-salary")
    public ResponseEntity<Double> calculateSalary(@RequestParam("employeeId") Long employeeId, @RequestParam("month") int month) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        double salary = workDayService.calculate_Salary(employee, month);
        return ResponseEntity.ok(salary);
    }
}
