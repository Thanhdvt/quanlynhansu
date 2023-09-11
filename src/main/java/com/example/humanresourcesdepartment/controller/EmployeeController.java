package com.example.humanresourcesdepartment.controller;

import com.example.humanresourcesdepartment.dto.EmployeeDto;
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
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
        List<EmployeeDto> list = employeeService.getAllEmloyee();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<EmployeeDto> getEmployeeByEmail(@PathVariable("email") String email) {
        EmployeeDto employeeDto = employeeService.getEmployeeByEmail(email);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @GetMapping("/position/{position}")
    public ResponseEntity<List<EmployeeDto>> getEmployeeByVaiTro(@PathVariable("position") String position) {
        List<EmployeeDto> list = employeeService.getEmployeeByPosition(position);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<EmployeeDto>> getEmployeeByStatus(@PathVariable("status") boolean status) {
        List<EmployeeDto> list = employeeService.getEmployeeByStatus(status);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}

