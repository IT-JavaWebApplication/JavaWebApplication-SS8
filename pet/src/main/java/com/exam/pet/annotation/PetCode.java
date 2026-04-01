package com.exam.pet.annotation;

import com.exam.pet.Validator.PetCodeValidator;
import jakarta.validation.Constrain;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validateBy = PetCodeValidator.class)
@Documented
public @interface PetCode {
   String message
}
