package com.app.employeedetails.repository;

import com.app.employeedetails.entity.AuthDtls;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDtlsRepository extends CrudRepository<AuthDtls, Long> {

    Optional<AuthDtls> findByUserName(String name);
}
