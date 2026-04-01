package com.example.bai3.model;

import com.example.bai3.validation.annotation.ValidWithdrawAmount;

public class WithdrawRequestDto {

    @ValidWithdrawAmount
    private Long withdrawAmount;

    // Getter, Setter...
    public Long getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(Long withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }
}