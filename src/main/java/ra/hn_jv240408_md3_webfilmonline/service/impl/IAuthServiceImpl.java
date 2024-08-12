package ra.hn_jv240408_md3_webfilmonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.hn_jv240408_md3_webfilmonline.dao.IRoleDao;
import ra.hn_jv240408_md3_webfilmonline.dao.IUserDao;
import ra.hn_jv240408_md3_webfilmonline.model.constant.Roles;
import ra.hn_jv240408_md3_webfilmonline.model.dto.request.FormLogin;
import ra.hn_jv240408_md3_webfilmonline.model.dto.request.FormRegister;
import ra.hn_jv240408_md3_webfilmonline.model.entity.Role;
import ra.hn_jv240408_md3_webfilmonline.model.entity.User;
import ra.hn_jv240408_md3_webfilmonline.service.IAuthService;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class IAuthServiceImpl implements IAuthService {

    @Autowired
    private IUserDao iUserDao;

    @Autowired
    private IRoleDao iRoleDao;

    @Override
    public User Login(FormLogin formLogin) {
        return iUserDao.Login(formLogin.getEmail(), formLogin.getPassword());
    }

    @Override
    public boolean Register(FormRegister formRegister) {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(iRoleDao.getRoleName(Roles.ROLE_USER));
        User user = User.builder()
                .fullName(formRegister.getFullName())
                .userName(formRegister.getUserName())
                .email(formRegister.getEmail())
                .password(formRegister.getPassword())
                .status(true)
                .isDelete(false)
                .createdDate(new Date())
                .roleSet(roleSet)
                .build();
        return iUserDao.Register(user);
    }
}
