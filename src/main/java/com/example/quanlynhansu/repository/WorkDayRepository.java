package com.example.quanlynhansu.repository;

import com.example.quanlynhansu.model.WorkDay;
import com.example.quanlynhansu.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WorkDayRepository extends JpaRepository<WorkDay, Long> {

    @Query("select count(wd) from WorkDay wd where wd.employee = :employee and month(wd.date) = :month and wd.has_work = true")
    int countNumberDayHasWork(@Param("employee") Employee employee, @Param("month") int month);
}

