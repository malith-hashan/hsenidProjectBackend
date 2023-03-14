package com.example.servyTest1.payload.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Set;

@Data
public class SignupRequest {
    private String username;

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private Set<String> roles;
    @NotBlank
    private String password;

}
