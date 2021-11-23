//package cvut.fit.twasp.Controller.REST;
//
//
//import cvut.fit.twasp.Model.GroupEntity;
//import cvut.fit.twasp.Service.GroupService;
//import javassist.NotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import javax.naming.directory.InvalidAttributesException;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("/api/groups")
//public class GroupControllerREST {
//    @Autowired
//    private GroupService groupService;
//
//    @PreAuthorize("hasRole('admin')")
//    @RequestMapping(value="/groups", method = RequestMethod.GET)
//    public ResponseEntity<?> getAll() {
//        return ResponseEntity.ok(groupService.findAll());
//    }
//
//    @PreAuthorize("hasRole('admin')")
//    @RequestMapping(value = "/group/create", method = RequestMethod.POST)
//    public ResponseEntity<GroupEntity> create(GroupEntity groupEntity){
//        try {
//            return ResponseEntity.ok(groupService.save(groupEntity));
//        } catch (InvalidAttributesException e) {
//            e.printStackTrace();
//        }
//        //TODO
//        return ResponseEntity.badRequest().build();
//    }
//
//    @PreAuthorize("hasRole('admin')")
//    @RequestMapping(value = "/group/update/{id}", method = RequestMethod.POST)
//    public ResponseEntity<GroupEntity> update(@PathVariable(value = "id") Long id, GroupEntity groupEntity){
//        try {
//            return ResponseEntity.ok(groupService.save(groupEntity));
//        } catch (InvalidAttributesException e) {
//            e.printStackTrace();
//        }
//        //TODO
//        return ResponseEntity.badRequest().build();
//    }
//
//    @PreAuthorize("hasRole('group_manager')")
//    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
//    public ResponseEntity<GroupEntity> getById(@PathVariable(value = "id") Long id) {
//        try {
//            return ResponseEntity.ok(groupService.findById(id));
//        } catch (NotFoundException e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @PreAuthorize("hasRole('group_manager')")
//    @RequestMapping(value="/group/{id}/add_user/{id_user}", method = RequestMethod.POST)
//    public ResponseEntity<GroupEntity> addUser(@PathVariable(value = "id") Long id, @PathVariable(value = "id_user") Long idUser) {
//        return ResponseEntity.ok(groupService.addUser(id, idUser));
//    }
//
//    @PreAuthorize("hasRole('group_manager')")
//    @RequestMapping(value="/group/{id}/delete_user/{id_user}", method = RequestMethod.POST)
//    public ResponseEntity<GroupEntity> deleteUser(@PathVariable(value = "id") Long id, @PathVariable(value = "id_user") Long idUser) {
//        return ResponseEntity.ok(groupService.deleteUser(id, idUser));
//    }
//
//    @PreAuthorize("hasRole('group_manager')")
//    @RequestMapping(value="/group/{id}/add_room/{id_room}", method = RequestMethod.POST)
//    public ResponseEntity<GroupEntity> addRoom(@PathVariable(value = "id") Long id, @PathVariable(value = "id_room") Long idRoom) {
//        return ResponseEntity.ok(groupService.addRoom(id, idRoom));
//    }
//
//    @PreAuthorize("hasRole('group_manager')")
//    @RequestMapping(value="/group/{id}/delete_room/{id_room}", method = RequestMethod.POST)
//    public GroupEntity deleteRoom(@PathVariable(value = "id") Long id, @PathVariable(value = "id_room") Long idRoom) {
//        return groupService.deleteRoom(id, idRoom);
//    }
//}
