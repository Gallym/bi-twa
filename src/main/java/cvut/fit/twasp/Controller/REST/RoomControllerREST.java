package cvut.fit.twasp.Controller.REST;

import cvut.fit.twasp.Model.Room;
import cvut.fit.twasp.Service.RoomService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/room")
public class RoomControllerREST {
    @Autowired
    private RoomService roomService;

    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
    //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/rooms", method = RequestMethod.GET)
    public List<Room> listRooms(){
        return roomService.findAll();
    }

    //@Secured("ROLE_USER")
    @PreAuthorize("hasRole('USER')")
    ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.GET)
    public Room getOne(@PathVariable(value = "id") Long id) throws NotFoundException {
        return roomService.findById(id);
    }


//    @RequestMapping(value="/signup", method = RequestMethod.POST)
//    public Room saveRoom(@RequestBody UserDto user){
//        return roomService.save(user);
//    }




}
