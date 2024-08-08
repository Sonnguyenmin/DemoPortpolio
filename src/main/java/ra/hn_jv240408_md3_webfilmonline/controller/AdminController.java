package ra.hn_jv240408_md3_webfilmonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/index")
    public String index(Model model) {
        return "admin/index";
    }

    @GetMapping("/category")
    public String category(Model model) {
        return "admin/category/listCategory";
    }

    @GetMapping("/add_category")
    public String addCategory(Model model) {
        return "admin/category/addCategory";
    }

    @GetMapping("/edit_category")
    public String editCategory(Model model) {
        return "admin/category/editCategory";
    }

    @GetMapping("/detail_category")
    public String detailCategory(Model model) {
        return "admin/category/detailCategory";
    }
}
