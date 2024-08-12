package ra.hn_jv240408_md3_webfilmonline.service;

import ra.hn_jv240408_md3_webfilmonline.model.dto.request.FormLogin;
import ra.hn_jv240408_md3_webfilmonline.model.dto.request.FormRegister;
import ra.hn_jv240408_md3_webfilmonline.model.entity.User;

public interface IAuthService {
    User Login (FormLogin formLogin);
    boolean Register (FormRegister formRegister);

}
