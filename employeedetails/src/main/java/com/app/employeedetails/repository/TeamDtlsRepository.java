package com.app.employeedetails.repository;

import com.app.employeedetails.entity.TeamDtls;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamDtlsRepository extends CrudRepository<TeamDtls, Long> {
}