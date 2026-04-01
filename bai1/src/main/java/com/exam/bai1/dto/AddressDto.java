package com.exam.bai1.dto;

import jakarta.validation.constraints.NotBlank;

public class AddressDto {

    @NotBlank(message = "Tên người nhận không được để trống hoặc chỉ chứa khoảng trắng")
    private String receiverName;

    @NotBlank(message = "Địa chỉ chi tiết không được để trống hoặc chỉ chứa khoảng trắng")
    private String detailedAddress;

    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }

    public String getDetailedAddress() { return detailedAddress; }
    public void setDetailedAddress(String detailedAddress) { this.detailedAddress = detailedAddress; }
}