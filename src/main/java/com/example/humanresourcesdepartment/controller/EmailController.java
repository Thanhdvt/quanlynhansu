package com.example.humanresourcesdepartment.controller;


import com.example.humanresourcesdepartment.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/number-work-day")
    public ResponseEntity<String> sendEmailNumberWorkDay() {
        emailService.sendEmailNumberWorkDay();
        return ResponseEntity.ok("Sended mail for confirm workday");
    }

    @GetMapping("/rest-work-day")
    public ResponseEntity<String> sendEmailRestWOrkDay() {
        emailService.sendEmailRestWorkDay();
        return ResponseEntity.ok("Sended mail for confirm rest work day");
    }
}
