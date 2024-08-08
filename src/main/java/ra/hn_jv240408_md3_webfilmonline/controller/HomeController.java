package ra.hn_jv240408_md3_webfilmonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        return "main/home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "page/register";
    }

    @GetMapping("/404")
    public String notFound(Model model) {
        return "page/404";
    }

    @GetMapping("/403")
    public String Forbidden(Model model) {
        return "page/403";
    }
}
