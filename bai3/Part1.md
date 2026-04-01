Phần 1: Báo cáo phân tích và Thiết kế giải pháp
1. Xác định Input/OutputInput: Trường withdrawAmount kiểu dữ liệu Long hoặc BigDecimal (ở đây dùng Long để tối ưu cho 
tiền VNĐ không có số lẻ).Output: * True: Nếu số tiền hợp lệ ($\ge 50,000$ và chia hết cho $10,000$).False: Nếu vi 
phạm bất kỳ điều kiện nào hoặc dữ liệu bị "bẫy" (null, số âm). Kèm theo thông báo lỗi cụ thể.
2. Đề xuất phương án Sử dụng cơ chế Bean Validation (JSR 380). Tạo một Custom Annotation tên là @ValidWithdrawAmount. 
Tại sao không tách rời @Min(50000)? Mặc dù có thể dùng @Min, nhưng để đáp ứng tính "đóng gói" của nghiệp vụ rút tiền ATM
, việc gộp chung vào một Validator đặc thù sẽ giúp thông báo lỗi đồng nhất và dễ bảo trì hơn.
3. Sơ đồ logic kiểm tra (Pseudocode)PlaintextFUNCTION isValid(value, context):
IF value IS NULL:
RETURN FALSE (Bẫy null: Rút tiền không được để trống)

    IF value < 50000:
        RETURN FALSE (Vi phạm hạn mức tối thiểu)
        
    IF value MOD 10000 != 0:
        RETURN FALSE (Không phải bội số của 10k - ATM không nhả được tiền)
        
    RETURN TRUE (Hợp lệ)