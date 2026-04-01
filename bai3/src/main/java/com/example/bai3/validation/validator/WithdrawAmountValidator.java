package com.example.bai3.validation.validator;

import com.example.bai3.validation.annotation.ValidWithdrawAmount;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class WithdrawAmountValidator implements ConstraintValidator<ValidWithdrawAmount, Long> {

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        // 1. Xử lý bẫy null (Best practice: null là không hợp lệ cho nghiệp vụ này)
        if (value == null) {
            return false;
        }

        // 2. Kiểm tra điều kiện >= 50.000 (Chống luôn cả số âm)
        if (value < 50000) {
            return false;
        }

        // 3. Kiểm tra bội số của 10.000
        return value % 10000 == 0;
    }
}