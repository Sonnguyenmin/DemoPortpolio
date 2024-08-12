package ra.hn_jv240408_md3_webfilmonline.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.hn_jv240408_md3_webfilmonline.dao.IRoleDao;
import ra.hn_jv240408_md3_webfilmonline.model.constant.Roles;
import ra.hn_jv240408_md3_webfilmonline.model.entity.Role;

@Repository
public class IRoleDaoImpl implements IRoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role getRoleName(Roles roleName) {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from Role where roleName= :roleName", Role.class)
                    .setParameter("roleName", roleName)
                    .getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }
}
