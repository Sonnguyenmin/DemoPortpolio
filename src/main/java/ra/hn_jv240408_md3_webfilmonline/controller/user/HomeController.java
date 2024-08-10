package ra.hn_jv240408_md3_webfilmonline.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/user")
public class HomeController {
    @GetMapping("/home")
    public String home(Model model) {
        return "user/home";
    }

    @GetMapping("/404")
    public String notFound(Model model) {
        return "page/404";
    }

    @GetMapping("/403")
    public String Forbidden(Model model) {
        return "page/403";
    }

    @GetMapping("/detail")
    public String detail(Model model) {
        return "user/detail";
    }

}
