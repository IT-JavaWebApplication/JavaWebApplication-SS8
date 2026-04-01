Phần 1: Phân tích Logic
Đoạn mã hiện tại gặp lỗi do hai nguyên nhân chính sau:

1. Tại sao lọt khoảng trắng vào Database?
   Lỗi sử dụng @NotNull: Annotation này chỉ kiểm tra xem giá trị có bị null hay không. Đối với kiểu dữ liệu String, một 
2. chuỗi chứa toàn khoảng trắng ("   ") hoặc chuỗi rỗng ("") không phải là null.

Do đó, khi người dùng nhập dấu cách, @NotNull vẫn coi đó là hợp lệ và cho phép đi tiếp vào logic lưu Database.

2. Tại sao không chặn được Postman và gây lỗi 500?
   Thiếu @Valid tại Controller: Trong phương thức updateAddress, tham số @RequestBody AddressDto addressDto thiếu 
3. annotation @Valid (hoặc @Validated). Nếu không có nhãn này, Spring Boot sẽ bỏ qua hoàn toàn việc kiểm tra các 
4. annotation Bean Validation bên trong DTO.

Lỗi 500: Khi Postman gửi dữ liệu không hợp lệ (ví dụ thiếu hẳn trường dữ liệu dẫn đến null), nhưng vì Controller không 
chặn lại ở tầng Validation, code xử lý bên trong (Logic lưu database) có thể gặp lỗi NullPointerException hoặc lỗi ràng 
buộc DB (Constraint Violation). Khi một Exception không được bắt, Spring sẽ mặc định trả về 500 Internal Server Error.