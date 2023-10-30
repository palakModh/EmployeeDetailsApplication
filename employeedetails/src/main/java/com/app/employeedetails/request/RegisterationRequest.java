package com.app.employeedetails.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterationRequest {
    @NotEmpty(message = "Username is mandatory")
    private String username;

    @NotEmpty(message = "Password is mandatory")
    private String password;

    @NotEmpty(message = "Employee name is mandatory")
    private String empName;

    @NotEmpty(message = "Department Id is mandatory")
    private String deptId;

    @NotEmpty(message = "Designation Id is mandatory")
    private String desinationId;

    @NotEmpty(message = "Technology Id is mandatory")
    private String techId;

    @NotEmpty(message = "Manager name is mandatory")
    private String managerName;
}