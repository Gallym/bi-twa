//package cvut.fit.twasp.Controller;
//
//import cvut.fit.twasp.Model.GroupEntity;
//import cvut.fit.twasp.Service.GroupService;
//import javassist.NotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.naming.directory.InvalidAttributesException;
//
//@Controller
//public class GroupController {
//    @Autowired
//    private GroupService groupService;
//
//    @GetMapping(value = "/groups")
//    public String getAll(Model model) {
//        model.addAttribute("groups", groupService.findAll());
//        return "groupList";
//    }
//
//    @GetMapping(value = "/groups/{id}", produces = "application/json")
//    public String getById(Model model, @PathVariable(value = "id") Long id) {
//        try {
//            model.addAttribute("groups", groupService.findById(id));
//        } catch (NotFoundException e) {
//            // TODO
//            e.printStackTrace();
//        }
//        return "group";
//    }
//
//    @PostMapping(value = "/create_group")
//    public String create(Model model, GroupEntity groupEntity) {
//        try {
//            model.addAttribute("group", groupService.save(groupEntity));
//        } catch (InvalidAttributesException e) {
//            // TODO
//            e.printStackTrace();
//        }
//        //TODO
//        return "createGroup";
//    }
//    //TODO: deleteGroup
//}
