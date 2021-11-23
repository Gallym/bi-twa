package cvut.fit.twasp.Controller;

import cvut.fit.twasp.Service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String getAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user_list";
    }

    @GetMapping(value = "/users/{id}")
    public String getById(Model model, @PathVariable(value = "id") Long id) {
        try {
            model.addAttribute("user", userService.findById(id));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "user";
    }

    @GetMapping(value = "/users/search_by_email/{email}")
    public String getByEmail(Model model, @PathVariable(value = "email") String email) {
        try {
            model.addAttribute("user", userService.findByEmail(email));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "user";
    }

}
