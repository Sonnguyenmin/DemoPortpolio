package ra.hn_jv240408_md3_webfilmonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.hn_jv240408_md3_webfilmonline.dao.IUserDao;
import ra.hn_jv240408_md3_webfilmonline.model.entity.User;
import ra.hn_jv240408_md3_webfilmonline.service.IUserService;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
