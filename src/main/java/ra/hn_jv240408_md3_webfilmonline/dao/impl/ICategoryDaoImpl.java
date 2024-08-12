package ra.hn_jv240408_md3_webfilmonline.dao.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ra.hn_jv240408_md3_webfilmonline.dao.ICategoryDao;
import ra.hn_jv240408_md3_webfilmonline.model.entity.Category;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ICategoryDaoImpl implements ICategoryDao {

    private final SessionFactory sessionFactory;

    @Override
    public List<Category> findAll() {
        Session session = sessionFactory.openSession();
        try{
            List categoryList = session.createQuery("from Category").list();
            return categoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }

    @Override
    public Category getCategoryById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            Category category = session.get(Category.class, id);
            return category;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Boolean saveCategory(Category category) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(category);
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
    public Boolean updateCategory(Category category) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(category);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public Boolean deleteCategory(Long id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(getCategoryById(id));
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();

        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<Category> getCategoryByName(String categoryName) {
        Session session = sessionFactory.openSession();
        try {
            if (categoryName == null || categoryName.isEmpty()) {
                categoryName = "%";
            }
            else  {
                categoryName = "%" + categoryName + "%";
            }
            List list = session.createQuery("from Category where categoryName like: categoryName")
                    .setParameter("categoryName", categoryName)
                    .list();
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
