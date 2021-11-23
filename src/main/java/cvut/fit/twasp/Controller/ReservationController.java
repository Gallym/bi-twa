package cvut.fit.twasp.Controller;

import cvut.fit.twasp.Model.Reservation;
import cvut.fit.twasp.Model.User;
import cvut.fit.twasp.Service.ReservationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.directory.InvalidAttributesException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PreAuthorize("hasAnyAuthority('ADMIN', 'GROUP_MANAGER', 'ROOM_MANAGER')")
    @GetMapping(value = "/my_unapproved_reservations")
    public String getAllUnapprovedReservations(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("reservations", reservationService.getAllUnapprovedForManager(user));
        return "unapproved_reservations";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'GROUP_MANAGER', 'ROOM_MANAGER')")
    @PostMapping(value = "/{id}/approve")
    public String approve(@AuthenticationPrincipal User user, @PathVariable Long id) {
        try {
            reservationService.approveReservation(user, id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/reservation/my_unapproved_reservations";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'GROUP_MANAGER', 'ROOM_MANAGER', 'USER', 'GROUP_MEMBER')")
    @GetMapping(value = "/my_reservations")
    public String getAllUsersReservation(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("reservations", reservationService.getUsersReservations(user));
        return "users_reservations";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'GROUP_MANAGER', 'ROOM_MANAGER', 'USER', 'GROUP_MEMBER')")
    @GetMapping(value = "/new_reservation")
    public String newReservation(@AuthenticationPrincipal User user,
                                    Model model) {
        model.addAttribute("rooms", user.getRooms());
        return "new_reservation";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'GROUP_MANAGER', 'ROOM_MANAGER', 'USER', 'GROUP_MEMBER')")
    @PostMapping(value = "/create_reservation")
    public String createReservation(@AuthenticationPrincipal User user,
                                    @RequestParam Map<String, String> form,
                                    Model model) throws InvalidAttributesException {
        //reservationService.save(user, reservation);
        Date date = null;
        String roomName = null;
        for (String key : form.keySet()) {
            if (key.equals("date")) {
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(form.get(key));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if (key.equals("room")) {
                roomName = form.get(key);
            }
        }
        reservationService.save(user, date, roomName);
        return "redirect:/reservation/my_reservations";
    }

}
