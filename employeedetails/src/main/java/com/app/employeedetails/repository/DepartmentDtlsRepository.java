package com.app.employeedetails.repository;

import com.app.employeedetails.entity.DepartmentDtls;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDtlsRepository extends CrudRepository<DepartmentDtls, Long> {
}
