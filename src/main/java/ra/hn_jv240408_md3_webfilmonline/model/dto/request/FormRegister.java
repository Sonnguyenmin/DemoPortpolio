package ra.hn_jv240408_md3_webfilmonline.model.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class FormRegister {

    @NotBlank(message = "Họ và tên không để trống")
    private String fullName;

    @NotBlank(message = "Tên không được để trống")
    private String userName;

    @NotBlank(message = "Email không được để trống")
    @NotBlank(message = "Email đã tồn tại")
    private String email;

    @NotBlank(message = "Mật khẩu không để trống")
    private String password;
}
