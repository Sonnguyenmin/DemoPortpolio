package ra.hn_jv240408_md3_webfilmonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.hn_jv240408_md3_webfilmonline.dao.ICategoryDao;
import ra.hn_jv240408_md3_webfilmonline.model.entity.Category;
import ra.hn_jv240408_md3_webfilmonline.service.ICategoryService;

import java.util.List;
@Service
public class ICategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public Boolean saveCategory(Category category) {
        return categoryDao.saveCategory(category);
    }

    @Override
    public Boolean updateCategory(Category category) {
        return categoryDao.updateCategory(category);
    }

    @Override
    public Boolean deleteCategory(Long id) {
        return categoryDao.deleteCategory(id);
    }

    @Override
    public List<Category> getCategoryByName(String categoryName) {
        return categoryDao.getCategoryByName(categoryName);
    }
}
