package com.example.bai4.model;

import com.example.bai4.annotation.PasswordMatches;

@PasswordMatches
public class UserRegistrationDto {

    private String username;

    @NotBlank(message = "Mật khẩu không được để trống")
    private String password;

    private String confirmPassword;

    // Getters and Setters...
}