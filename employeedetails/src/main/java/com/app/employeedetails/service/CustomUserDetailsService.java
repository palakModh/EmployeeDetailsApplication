package com.app.employeedetails.service;

import com.app.employeedetails.entity.*;
import com.app.employeedetails.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    DesignationDtlsRepository designationDtlsRepo;

    @Autowired
    UserDtlsRepository userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    DepartmentDtlsRepository deptRepo;

    @Autowired
    EmployeeDtlsRepository empRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userRepo.findByUserName(username).isEmpty())
            throw new UsernameNotFoundException("No user found.");

        AuthDtls userDtls = userRepo.findByUserName(username).get();
        return User.withUsername(username).password(userDtls.getPassword()).build();
    }


}