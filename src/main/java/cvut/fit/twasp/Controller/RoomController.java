package cvut.fit.twasp.Controller;

import cvut.fit.twasp.Model.User;
import cvut.fit.twasp.Service.RoomService;
import cvut.fit.twasp.Service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/rooms")
    public String getAll(Model model) {
        model.addAttribute("rooms", roomService.findAll());
        return "roomList";
    }

    //@PreAuthorize("hasAnyRole('USER', 'ADMIN', 'ROOM_MANAGER')")
    @GetMapping(value = "/my_rooms")
    public String getAllMyRooms(@AuthenticationPrincipal User user, Model model) {
        try {
            model.addAttribute("rooms", userService.findById(user.getId()).getRooms());
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "roomList";
    }

    @GetMapping(value = "/available_rooms/{date}")
    public String getAllAvailable(Date date, Model model) {
        model.addAttribute("rooms", roomService.findAllAvailable(date));
        model.addAttribute("date", date);

        return "available_rooms";
    }

    @GetMapping(value = "/rooms/{id}", produces = "application/json")
    public String getById(Model model, @PathVariable(value = "id") Long id) {
        try {
            model.addAttribute("groups", roomService.findById(id));
        } catch (NotFoundException e) {
            // TODO
            e.printStackTrace();
        }
        return "room";
    }

}
