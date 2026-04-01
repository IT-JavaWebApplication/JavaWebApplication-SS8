package com.example.bai3.validation.annotation;

import com.example.bai3.validation.validator.WithdrawAmountValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = WithdrawAmountValidator.class) // Chỉ định class xử lý logic
@Target({ElementType.FIELD}) // Áp dụng trên cấp độ thuộc tính
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidWithdrawAmount {
    String message() default "Số tiền rút phải từ 50.000 VNĐ và là bội số của 10.000 VNĐ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] medical() default {};
}