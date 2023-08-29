package com.example.quanlynhansu.repository;

import com.example.quanlynhansu.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmail(String email);

    List<Employee> findByPosition(String position);

    List<Employee> findByStatusEmployee(boolean statusEmployee);

    List<Employee> findByNameContaining(String keyword);

    List<Employee> findByBirthDayBetween(Date start, Date end);

}
