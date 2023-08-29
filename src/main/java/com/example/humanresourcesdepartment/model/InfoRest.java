package com.example.humanresourcesdepartment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "info_rest")
public class InfoRest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seson", nullable = false)
    private String reason;

    @Column(name = "start_day", nullable = false)
    private Date startDay;

    @Column(name = "end_day", nullable = false)
    private Date endDay;

    @Column(name = "status", nullable = false)
    private String status;

    @CreationTimestamp
    @Column(name = "created_day", nullable = false)
    private Date createdDay;

    @UpdateTimestamp
    @Column(name="modified_day", nullable = false)
    private Date modifiedDay;

    @ManyToOne
    @JoinColumn(name = "empolyee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "leader_id", nullable = false)
    private Employee leader;

    public InfoRest updateInfo(InfoRest infoRest){
        this.setStartDay(infoRest.getStartDay());
        this.setEndDay(infoRest.getEndDay());
        this.setReason(infoRest.getReason());
        this.setStatus(infoRest.getStatus());
        this.setEmployee(infoRest.getEmployee());
        this.setLeader(infoRest.getLeader());
        return  infoRest;
    }
}
