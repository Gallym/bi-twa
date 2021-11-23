package cvut.fit.twasp.Controller;

import cvut.fit.twasp.Model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping(value = "/")
    public String welcome(Model model, Authentication authentication) {
        //User currentUser = (User) authentication.getPrincipal();
        //model.addAttribute("user", currentUser);
        return "home";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }
}
