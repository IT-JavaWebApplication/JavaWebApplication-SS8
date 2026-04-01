package com.example.bai4.validator;

import com.example.bai4.annotation.PasswordMatches;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.example.demo.dto.UserRegistrationDto; // Import DTO của bạn

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {

        UserRegistrationDto user = (UserRegistrationDto) obj;

        String password = user.getPassword();
        String confirmPassword = user.getConfirmPassword();

        if (password == null || confirmPassword == null) {
            return false;
        }

        return password.equals(confirmPassword);
    }
}