package com.example.democarcrud.auth;

import com.example.democarcrud.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String LastName;
    private String email;
    private String Password;
    private int cin;
    private int phoneNumber;
    private Role role;
}
