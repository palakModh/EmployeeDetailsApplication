package com.app.employeedetails.repository;

import com.app.employeedetails.entity.EmployeeDtls;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDtlsRepository extends CrudRepository<EmployeeDtls, Long> {
    Optional<EmployeeDtls> findByEmpName(String name);
}
