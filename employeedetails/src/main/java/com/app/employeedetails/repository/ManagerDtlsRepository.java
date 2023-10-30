package com.app.employeedetails.repository;

import com.app.employeedetails.entity.ManagerDtls;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerDtlsRepository extends CrudRepository<ManagerDtls, Long> {
    Optional<ManagerDtls> findByManagerName(String name);
}