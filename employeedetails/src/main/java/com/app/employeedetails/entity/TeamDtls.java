package com.app.employeedetails.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "team_dtls")
public class TeamDtls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_name")
    private String teamName;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    ManagerDtls managerDtls;

    @Embedded
    DefaultEntity defaultEntity;
}