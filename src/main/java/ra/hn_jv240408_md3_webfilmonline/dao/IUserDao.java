package ra.hn_jv240408_md3_webfilmonline.dao;

import ra.hn_jv240408_md3_webfilmonline.model.entity.User;

import java.util.List;

public interface IUserDao {
    User Login(String email, String password);
    boolean Register(User user);
    List<User> findAll();
}
