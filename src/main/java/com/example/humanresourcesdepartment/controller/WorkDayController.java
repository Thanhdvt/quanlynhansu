package com.example.humanresourcesdepartment.controller;

import com.example.humanresourcesdepartment.dto.EmployeeDto;
import com.example.humanresourcesdepartment.dto.WorkDayDto;
import com.example.humanresourcesdepartment.model.WorkDay;
import com.example.humanresourcesdepartment.model.Employee;
import com.example.humanresourcesdepartment.service.WorkDayService;
import com.example.humanresourcesdepartment.service.EmployeeService;
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
    public ResponseEntity<WorkDayDto> getWorkDayById(@PathVariable Long id) {
        WorkDayDto workDayDto = workDayService.getWorkDayById(id);
        if (workDayDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(workDayDto);
    }

    @PostMapping
    public ResponseEntity<WorkDayDto> saveWorkDay(@RequestBody WorkDayDto workDayDto) {
        WorkDayDto savedWorkDay = workDayService.saveWorkDay(workDayDto);
        return ResponseEntity.created(URI.create("/api/work-day/" + savedWorkDay.getId())).body(savedWorkDay);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkDay(@PathVariable Long id) {
        workDayService.deleteWorkDay(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/calculate-salary")
    public ResponseEntity<Double> calculateSalary(@RequestParam("employeeId") Long employeeId, @RequestParam("month") int month) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        if (employeeDto == null) {
            return ResponseEntity.notFound().build();
        }
        double salary = workDayService.calculate_Salary(employeeDto, month);
        return ResponseEntity.ok(salary);
    }
}
