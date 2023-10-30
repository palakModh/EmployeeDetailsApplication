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
@Table(name = "manager_dtls")
public class ManagerDtls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "manager_name")
    private String managerName;

    @OneToMany(mappedBy = "managerDtls")
    List<EmployeeDtls> employees;

    @Column(name = "reports_to_senior_vp", length = 1)
    private String reportsToSeniorVp;

    @OneToMany(mappedBy = "managerDtls")
    List<TeamDtls> teams;

    @Embedded
    DefaultEntity defaultEntity;
}
