package com.app.employeedetails.service;

import com.app.employeedetails.entity.*;
import com.app.employeedetails.exception.AppException;
import com.app.employeedetails.repository.*;
import com.app.employeedetails.request.LoginRequest;
import com.app.employeedetails.request.RegisterationRequest;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    UserDtlsRepository userRepo;

    @Autowired
    EmployeeDtlsRepository empRepo;

    @Autowired
    TeamDtlsRepository teamDtlsRepo;

    @Autowired
    ManagerDtlsRepository managerDtlsRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    DesignationDtlsRepository designationDtlsRepo;

    @Autowired
    DepartmentDtlsRepository deptRepo;

    @Transactional
    public String signUp(RegisterationRequest empRegReq) throws UsernameNotFoundException, AppException {
        Optional<ManagerDtls> manager = managerDtlsRepo.findByManagerName(empRegReq.getManagerName());
        if(!manager.isPresent())
            throw new AppException(HttpStatus.BAD_REQUEST.value(), "Manager not found");

        AuthDtls userDtls = AuthDtls.builder().userName(empRegReq.getUsername()).
                            password(passwordEncoder.encode(empRegReq.getPassword())).
                            defaultEntity(genDefaultEntity()).build();

        EmployeeDtls empDtls = EmployeeDtls.builder().empName(empRegReq.getEmpName()).
                deptId(Long.valueOf(empRegReq.getDeptId())).
                designationId(Long.valueOf(empRegReq.getDesinationId())).
                techId(Long.valueOf(empRegReq.getTechId())).
                managerDtls(manager.get()).
                userDtls(userDtls).
                defaultEntity(genDefaultEntity()).
                build();

        empRepo.save(empDtls);
        return "Signup successfully";
    }

    @Transactional
    public String login(LoginRequest loginRequest) throws UsernameNotFoundException, AppException {
        Optional<AuthDtls> authDtls = userRepo.findByUserName(loginRequest.getUsername());
        if(authDtls.isEmpty())
            throw new UsernameNotFoundException("Invalid username.");

        if(passwordEncoder.matches(loginRequest.getPassword(), authDtls.get().getPassword()))
            return "Login Successful";
        else
            throw new AppException(HttpStatus.BAD_REQUEST.value(), "Invalid password.");
    }

    @PostConstruct
    void populateData()
    {
        AuthDtls authDtls = AuthDtls.builder().userName("amol_ikke").
                password(passwordEncoder.encode("amol")).defaultEntity(new DefaultEntity(LocalDateTime.now(), null)).build();

        DepartmentDtls dept = DepartmentDtls.builder().deptName("IT").
                defaultEntity(genDefaultEntity()).build();

        TechnologyDtls techDtls = new TechnologyDtls();
        techDtls.setTechName("Java");
        techDtls.setDept(dept);
        dept.setTechnologyDtls(Arrays.asList(techDtls));
        deptRepo.save(dept);

        DesignationDtls designationDtls = new DesignationDtls();
        designationDtls.setDesignationName("Manager");
        designationDtls.setDefaultEntity(genDefaultEntity());
        designationDtlsRepo.save(designationDtls);

        EmployeeDtls employeeDtls = EmployeeDtls.builder().empName("Amol Ikke").
                deptId(1L).techId(1L).designationId(1L).userDtls(authDtls).
                defaultEntity(genDefaultEntity()).
                build();
        empRepo.save(employeeDtls);

        TeamDtls teamDtls = TeamDtls.builder().teamName("Digital").defaultEntity(genDefaultEntity()).build();
        teamDtlsRepo.save(teamDtls);

        ManagerDtls managerDtls = ManagerDtls.builder().
                        managerName("Amol Ikke").
                        teams(Arrays.asList(teamDtls)).
                        reportsToSeniorVp("Y").
                        defaultEntity(genDefaultEntity()).
                        build();
        managerDtlsRepo.save(managerDtls);

        teamDtls.setManagerDtls(managerDtls);
        teamDtlsRepo.save(teamDtls);
    }

    private DefaultEntity genDefaultEntity()
    {
        return new DefaultEntity(LocalDateTime.now(), null);
    }
}