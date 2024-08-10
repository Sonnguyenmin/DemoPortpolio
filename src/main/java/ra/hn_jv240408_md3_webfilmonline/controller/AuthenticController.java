package ra.hn_jv240408_md3_webfilmonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthenticController {
    @GetMapping("/")
    public String about(Model model) {
        return "user/about";
    }
}
