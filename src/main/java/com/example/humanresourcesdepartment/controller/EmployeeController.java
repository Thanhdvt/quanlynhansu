package com.example.humanresourcesdepartment.controller;

import com.example.humanresourcesdepartment.model.Employee;
import com.example.humanresourcesdepartment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> list = employeeService.getAllEmloyee();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable("email") String email) {
        Employee employee = employeeService.getEmployeeByEmail(email);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/position/{position}")
    public ResponseEntity<List<Employee>> getEmployeeByVaiTro(@PathVariable("position") String position) {
        List<Employee> list = employeeService.getEmployeeByPosition(position);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Employee>> getEmployeeByStatus(@PathVariable("status") boolean status) {
        List<Employee> list = employeeService.getEmployeeByStatus(status);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}

