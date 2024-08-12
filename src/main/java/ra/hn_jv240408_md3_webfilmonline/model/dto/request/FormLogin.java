package ra.hn_jv240408_md3_webfilmonline.model.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class FormLogin {
    @NotBlank(message = "Email chưa đúng hoặc đã tồn tại!")
    private String email;

    @NotBlank(message = "Mật chưa đúng vui lòng nhập lại!")
    private String password;
}
