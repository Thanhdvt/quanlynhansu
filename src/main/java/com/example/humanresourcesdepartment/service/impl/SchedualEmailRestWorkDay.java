package com.example.humanresourcesdepartment.service.impl;

import com.example.humanresourcesdepartment.dto.EmployeeDto;
import com.example.humanresourcesdepartment.dto.InfoRestDto;
import com.example.humanresourcesdepartment.service.InfoRestService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SchedualEmailRestWorkDay {
    private InfoRestService infoRestService;

    private EmailService emailService;
    SchedualEmailRestWorkDay(InfoRestService infoRestService, EmailService emailService){
        this.infoRestService = infoRestService;
        this.emailService = emailService;
    }

    @Scheduled(cron = "0 0 8 * * ?")
    public void sendEmailRestWorkDay() {
        Date date = new Date();
        int day = date.getDate(); //test
//        int day = date.getDate() - 1;
        List<InfoRestDto> list = infoRestService.getInfoRestByNgay(day);
        for (InfoRestDto infoRestDto : list) {
            EmployeeDto employeeDto = infoRestDto.getEmployeeDto();
            EmployeeDto leaderDto = infoRestDto.getLeaderDto();
            String subject = "Confirm RestDay Mail";
            String text = "Hi " + leaderDto.getName() + ",\n\n"
                    + "Employee " + employeeDto.getName() + " sended a mail for rest day (" + date + ").\n\n"
                    + "Reason : " + infoRestDto.getReason() + ".\n\n";
            emailService.sendEmail(leaderDto.getEmail(), subject, text);
            System.out.println("Sended mail rest work day of employee: " + employeeDto.getName());
        }
    }
}
