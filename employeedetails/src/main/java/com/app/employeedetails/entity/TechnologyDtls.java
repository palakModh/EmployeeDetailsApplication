package com.app.employeedetails.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "technology_dtls")
public class TechnologyDtls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tech_name")
    private String techName;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private DepartmentDtls dept;

    @Embedded
    DefaultEntity defaultEntity;
}