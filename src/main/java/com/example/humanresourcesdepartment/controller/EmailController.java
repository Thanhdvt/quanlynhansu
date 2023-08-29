package com.example.humanresourcesdepartment.controller;


import com.example.humanresourcesdepartment.service.impl.SchedualEmailRestWorkDay;
import com.example.humanresourcesdepartment.service.impl.SchedualForEmailNumberWorkDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    SchedualForEmailNumberWorkDay schedualForEmailNumberWorkDay;
    SchedualEmailRestWorkDay schedualEmailRestWorkDay;

    EmailController(SchedualForEmailNumberWorkDay schedualForEmailNumberWorkDay, SchedualEmailRestWorkDay schedualEmailRestWorkDay){
        this.schedualEmailRestWorkDay = schedualEmailRestWorkDay;
        this.schedualForEmailNumberWorkDay = schedualForEmailNumberWorkDay;
    }

    @GetMapping("/number-work-day")
    public ResponseEntity<String> sendEmailNumberWorkDay() {
        schedualForEmailNumberWorkDay.sendEmailNumberWorkDay();
        return ResponseEntity.ok("Sended mail for confirm workday");
    }

    @GetMapping("/rest-work-day")
    public ResponseEntity<String> sendEmailRestWOrkDay() {
        schedualEmailRestWorkDay.sendEmailRestWorkDay();
        return ResponseEntity.ok("Sended mail for confirm rest work day");
    }
}
