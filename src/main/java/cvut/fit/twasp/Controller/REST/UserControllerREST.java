package cvut.fit.twasp.Controller.REST;

import cvut.fit.twasp.Model.User;
import cvut.fit.twasp.Service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserControllerREST {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<User> getAll() {
        return userService.findAll();
    }

    @PreAuthorize("hasAnyRole('admin', 'group_manager', 'room_manager')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getById(@PathVariable(value = "id") Long id) throws NotFoundException {
        return userService.findById(id);
    }


//    @RequestMapping(value="/signup", method = RequestMethod.POST)
//    public User saveUser(@RequestBody UserDto user){
//        return userService.save(user);
//    }

}
