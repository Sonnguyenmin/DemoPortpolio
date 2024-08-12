package ra.hn_jv240408_md3_webfilmonline.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.hn_jv240408_md3_webfilmonline.model.entity.Category;
import ra.hn_jv240408_md3_webfilmonline.service.ICategoryService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")

public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/category")
    public String category(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "admin/category/listCategory";
    }

    @GetMapping("/add_category")
    public String addCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/category/addCategory";
    }

    @PostMapping("/add_category")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "admin/category/addCategory";
        }
        try {
            categoryService.saveCategory(category);
            return "redirect:/admin/category";
        } catch (Exception ex) {
            model.addAttribute("errorMessage", "Lỗi khi lưu danh mục: " + ex.getMessage());
            return "admin/category/addCategory";
        }
    }

    @GetMapping("/edit_category/{id}")
    public String editCategory(@PathVariable Long id , Model model) {
        Category updateCate = categoryService.getCategoryById(id);
        model.addAttribute("category", updateCate);
        return "admin/category/editCategory";
    }

    @PostMapping("/edit_category")
    public String editCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
        try {
            Category existCate = categoryService.getCategoryById(category.getId());
            if (existCate == null) {
                model.addAttribute("errorMessage", "Danh mục không tồn tại. ");
                return "admin/category/editCategory";
            }
            existCate.setCategoryName(category.getCategoryName());
            existCate.setStatus(category.getStatus());
            categoryService.updateCategory(existCate);
            return "redirect:/admin/category";
        } catch (Exception ex) {
            ex.printStackTrace();
            model.addAttribute("errorMessage", "Lỗi khi cập nhật danh mục film: " + ex.getMessage());
            model.addAttribute("category", category);
            return "admin/category/editCategory";
        }
    }

    @GetMapping("/delete_category/{id}")
    public String deleteCategory(@PathVariable Long id, Model model) {
        try {
            Category category = categoryService.getCategoryById(id);
            if (category != null) {
                categoryService.deleteCategory(id);
                return "redirect:/admin/category";
            } else {
                model.addAttribute("errorMessage", "danh mục film không tồn tại.");
                return "redirect:/admin/category";
            }
        }catch (Exception ex) {
            model.addAttribute("errorMessage", "Lỗi khi xóa sản phẩm: " + ex.getMessage());
            return "redirect:/admin/category";
        }
    }


    @GetMapping("/detail_category/{id}")
    public String detailCategory(@PathVariable Long id, Model model) {
        try {
            Category category = categoryService.getCategoryById(id);
            if (category == null) {
                model.addAttribute("errorMessage", "Danh mục film không tồn tại.");
                return "redirect:/admin/category";
            }
            model.addAttribute("category", category);
            List<Category> categoryList = categoryService.findAll();
            model.addAttribute("categoryList", categoryList);
            return "admin/category/detailCategory";
        } catch (Exception ex) {
            model.addAttribute("errorMessage", "Lỗi khi lấy thông tin danh mục: " + ex.getMessage());
            return "admin/category/detailCategory";
        }
    }


}
