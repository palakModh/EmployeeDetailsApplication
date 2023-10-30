package com.app.employeedetails.repository;

import com.app.employeedetails.entity.TechnologyDtls;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyDtlsRepository extends CrudRepository<TechnologyDtls, Long> {
}
