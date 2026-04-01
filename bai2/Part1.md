Phần 1: Phân tích - Tại sao code "đúng" mà vẫn lỗi?
Vấn đề không nằm ở logic bên trong hàm, mà nằm ở thứ tự các tham số trong phương thức saveEmployee.

Trong Spring MVC, quy tắc vàng khi làm việc với Validation là:

Đối tượng BindingResult (hoặc Errors) BẮT BUỘC phải nằm ngay sau đối tượng được kiểm tra (đối tượng có annotation @Valid 
hoặc @ModelAttribute).

Lỗi cụ thể trong code của bạn:
Bạn đang đặt Model model xen giữa EmployeeDto employee và BindingResult bindingResult.

@Valid @ModelAttribute("employee") EmployeeDto employee

Model model <-- "Kẻ ngáng đường"

BindingResult bindingResult

Khi Spring thấy tham số @Valid, nó sẽ tiến hành kiểm tra dữ liệu. Nếu có lỗi xảy ra (như tuổi = 16), Spring sẽ tìm kiếm 
ngay tham số tiếp theo xem có phải là BindingResult hay không để "đổ" lỗi vào đó. Vì tham số tiếp theo của bạn lại là 
Model, Spring bị "bối rối", mặc định rằng bạn không muốn tự xử lý lỗi và sẽ ném thẳng ra một ngoại lệ (BindException 
hoặc MethodArgumentNotValidException). Điều này dẫn đến lỗi 400 Bad Request và trang trắng mà HR đang phải chịu đựng.