package com.app.employeedetails.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_dtls")
public class EmployeeDtls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "eployee_name")
    private String empName;

    @ManyToOne
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private DepartmentDtls dept;

    @Column(name = "department_id")
    private Long deptId;

    @ManyToOne
    @JoinColumn(name = "designation_id", insertable = false, updatable = false)
    private DesignationDtls designation;

    @Column(name = "designation_id")
    private Long designationId;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    ManagerDtls managerDtls;

    @OneToOne
    @JoinColumn(name = "tech_id", insertable = false, updatable = false)
    private TechnologyDtls technologyDtls;

    @Column(name = "tech_id")
    private Long techId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private AuthDtls userDtls;

    @Embedded
    DefaultEntity defaultEntity;
}
