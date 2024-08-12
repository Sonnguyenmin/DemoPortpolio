package ra.hn_jv240408_md3_webfilmonline.dao;

import ra.hn_jv240408_md3_webfilmonline.model.entity.Category;

import java.util.List;

public interface ICategoryDao {
    List<Category> findAll();
    Category getCategoryById(Long id);
    Boolean saveCategory (Category category);
    Boolean updateCategory (Category category);
    Boolean deleteCategory (Long id);
    List<Category> getCategoryByName(String categoryName);
}
