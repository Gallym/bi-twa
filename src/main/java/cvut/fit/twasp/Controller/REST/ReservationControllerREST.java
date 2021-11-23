package cvut.fit.twasp.Controller.REST;

import cvut.fit.twasp.Model.Reservation;
import cvut.fit.twasp.Model.User;
import cvut.fit.twasp.Service.ReservationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.naming.directory.InvalidAttributesException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/reservation")
public class ReservationControllerREST {
    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value="/reservation", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
    public ResponseEntity<Reservation> getById(@PathVariable(value = "id") Long id) throws NotFoundException {
        return ResponseEntity.ok(reservationService.findById(id));
    }

    @PreAuthorize("hasAnyRole('room_user', 'room_manager', 'group_member', 'group_manager', 'admin')")
    @RequestMapping(value = "/reservation/{id_user}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllByUser(@PathVariable(value = "id_user") Long userId) {
        return ResponseEntity.ok(reservationService.getUsersReservations(userId));
    }


    // TODO: create only for the user
//    @PreAuthorize("hasAnyRole('room_user', 'room_manager', 'group_member', 'group_manager', 'admin')")
//    @RequestMapping(value = "/reservation/create", method = RequestMethod.POST)
//    public ResponseEntity<Reservation> create(/*@PathVariable(value = "user") User user,*/
//                                              @AuthenticationPrincipal User user ,
//                                              @RequestBody Reservation reservation) throws InvalidAttributesException {
//        return ResponseEntity.ok(reservationService.save(user, reservation));
//    }
    // TODO: delete only for the user
    // TODO: update only for the user
}
