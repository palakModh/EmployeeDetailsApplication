package com.app.employeedetails.repository;

import com.app.employeedetails.entity.DesignationDtls;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationDtlsRepository extends CrudRepository<DesignationDtls, Long> {
}
