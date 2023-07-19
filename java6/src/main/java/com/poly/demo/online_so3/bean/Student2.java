package com.poly.demo.online_so3.bean;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student2 {
    
    @NotBlank(message = "Không được để trống email")
    @Email(message = "Email không hợp lệ")
    String email;
    @NotBlank(message = "Không được để trống họ và tên")
    String fullname;
    @NotNull(message = "Không được để trống điểm")
    @PositiveOrZero(message = "Điểm phải lớn hơn hoặc bằng 0")
    @Max(value = 10,message = "Điểm phải nhỏ hơn hoặc bằng 10")
    Double marks;
    @NotNull(message = "Vui lòng chọn giới tính")
    Boolean gender;
    @NotBlank(message = "Vui lòng chọn quốc tịch")
    String country;
}
