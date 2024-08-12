package ra.hn_jv240408_md3_webfilmonline.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping({"/dashboard", "dashboard.html"})
    public String dashboard() {
        return "admin/dashboard";
    }
}
