# Báo cáo Phân tích & Giải pháp: Cross-field Validation

## Phần 1: Phân tích & Đề xuất đa giải pháp

### 1. Xác định Input/Output
* **Input**: Đối tượng DTO (Data Transfer Object) chứa thông tin đăng ký gồm 3 trường:
    * `username`: Tên đăng nhập.
    * `password`: Mật khẩu người dùng nhập.
    * `confirmPassword`: Mật khẩu xác nhận lại.
* **Output**:
    * **Hợp lệ**: Khi `password` và `confirmPassword` trùng khớp hoàn toàn. Hệ thống tiếp tục xử lý đăng ký.
    * **Không hợp lệ**: Trả về thông báo lỗi "Mật khẩu xác nhận không khớp" và chặn quá trình xử lý tiếp theo.

### 2. Các giải pháp kỹ thuật đề xuất

#### Giải pháp 1: Xử lý thủ công (Manual Logic)
Thực hiện kiểm tra trực tiếp bên trong lớp **Controller** hoặc lớp **Service** bằng các câu lệnh điều kiện `if-else`.
* **Cách làm**: Sau khi nhận DTO, gọi `dto.getPassword().equals(dto.getConfirmPassword())`. Nếu sai thì ném ra ngoại lệ hoặc trả về View kèm thông báo lỗi.

#### Giải pháp 2: Sử dụng Class-Level Annotation (Custom Validator)
Tạo một Annotation tùy chỉnh (ví dụ: `@PasswordMatches`) và gắn nó lên cấp độ lớp của DTO.
* **Cách làm**: Khai báo một Annotation và một lớp Validator triển khai giao diện `ConstraintValidator`. Spring Bean Validation sẽ tự động gọi logic này khi có annotation `@Valid` trong Controller.

---

## Phần 2: So sánh & Lựa chọn giải pháp

Dưới đây là bảng so sánh chi tiết giữa hai giải pháp dựa trên các tiêu chí kỹ thuật:

| Tiêu chí so sánh | Giải pháp 1: Xử lý thủ công | Giải pháp 2: Class-Level Annotation |
| :--- | :--- | :--- |
| **Boilerplate Code** | **Nhiều**: Phải viết đi viết lại logic so sánh ở mọi phương thức xử lý form mật khẩu. | **Ít**: Định nghĩa logic một lần, tái sử dụng bằng cách gọi tên Annotation. |
| **Khả năng tái sử dụng** | **Thấp**: Code bị dính chặt (hard-coded) vào một Controller cụ thể. | **Cao**: Có thể áp dụng cho bất kỳ DTO nào (Đăng ký, Đổi mật khẩu, Quên mật khẩu). |
| **Separation of Concerns** | **Vi phạm**: Controller phải làm cả việc điều hướng lẫn kiểm tra logic dữ liệu sâu. | **Tốt**: Tách biệt hoàn toàn tầng Validation ra khỏi tầng xử lý nghiệp vụ (Service/Controller). |
| **Trải nghiệm người dùng** | Khó tích hợp đồng bộ với các lỗi validation khác (như `@Email`, `@Size`). | Tích hợp mượt mà, trả về tất cả các lỗi cùng một lúc qua `BindingResult`. |

# Kết luận lựa chọn
**Giải pháp 2: Class-Level Annotation** là giải pháp tối ưu nhất.

Nó tuân thủ nguyên tắc **DRY** (Don't Repeat Yourself) và giúp mã nguồn sạch sẽ, dễ bảo trì hơn trong môi trường dự án thực tế. Ngoài ra, nó giúp ngăn chặn các lỗi tiềm ẩn như `NullPointerException` một cách tập trung tại một nơi duy nhất.