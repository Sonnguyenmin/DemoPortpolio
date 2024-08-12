package ra.hn_jv240408_md3_webfilmonline.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.hn_jv240408_md3_webfilmonline.dao.IUserDao;
import ra.hn_jv240408_md3_webfilmonline.model.entity.User;

import java.util.List;

@Repository
public class IUserDaoImpl implements IUserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User Login(String email, String password) {
        // Đăng nhập <- kiểm tra tài khoản trùng khớp trong cơ sở dữ liệu
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from User where email =: email and password= :password", User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean Register(User user) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        try{
            List list = session.createQuery("from User", User.class).list();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }
}
