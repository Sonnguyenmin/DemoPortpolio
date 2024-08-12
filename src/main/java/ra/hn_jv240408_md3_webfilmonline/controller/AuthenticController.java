package ra.hn_jv240408_md3_webfilmonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.hn_jv240408_md3_webfilmonline.model.constant.Roles;
import ra.hn_jv240408_md3_webfilmonline.model.dto.request.FormLogin;
import ra.hn_jv240408_md3_webfilmonline.model.dto.request.FormRegister;
import ra.hn_jv240408_md3_webfilmonline.model.entity.User;
import ra.hn_jv240408_md3_webfilmonline.service.IAuthService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("")
public class AuthenticController {
    @Autowired
    private IAuthService authService;
    @Autowired
    private HttpSession httpSession;

    @GetMapping("/")
    public String index() {
        return "page/index";
    }

    @GetMapping("/register")
    public String formRegister(Model model) {
        model.addAttribute("formRegister", new FormRegister());
        return "page/register";
    }

    @PostMapping("/register")
    public String Register(@Valid @ModelAttribute FormRegister formRegister, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("formRegister", formRegister);
            return "page/register";
        }
        authService.Register(formRegister);
        return "/page/login";
    }


    @GetMapping("/login")
    public String formLogin(Model model) {
        model.addAttribute("formLogin", new FormLogin());
        return "page/login";
    }

    @PostMapping("/login")
    public String Login (@Valid @ModelAttribute("formLogin") FormLogin formLogin, BindingResult bindingResult, Model model, HttpSession httpSession) {
        // nếu có người dùng -> trang chủ + tạo tài khoản phiên trong trình duyệt // -> đặt lại trang đăng nhập
        // Xác thực đầu vào
        if (bindingResult.hasErrors()) {
            model.addAttribute("formLogin", formLogin);
            return "page/login";
        }

        User user = authService.Login(formLogin);

        if (user != null) {
            // Lưu người dùng hiện tại
            httpSession.setAttribute("userCurrent", user);
            // kiểm tra vai trò admin
            if (user.getRoleSet().stream().anyMatch(item -> item.getRoleName().equals(Roles.ROLE_ADMIN))){
                return "redirect:/admin/dashboard";
            }
            return "redirect:/user/home";
        } else {
            model.addAttribute("error", "Email hoặc mật khẩu không hợp lệ");
            return "/page/login";
        }
    }

    @GetMapping("/logout")
    public String logout(){
        return "page/index";
    }

}
