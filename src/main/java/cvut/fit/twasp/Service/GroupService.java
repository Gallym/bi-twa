//package cvut.fit.twasp.Service;
//
//import cvut.fit.twasp.Model.GroupEntity;
//import javassist.NotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.naming.directory.InvalidAttributesException;
//import java.util.List;
//
//@Service
//public interface GroupService {
//    List<GroupEntity> findAll();
//
//    GroupEntity findById(Long id) throws NotFoundException;
//
//    GroupEntity save(GroupEntity group) throws InvalidAttributesException;
//
//    GroupEntity update(Long id, GroupEntity group) throws NotFoundException, InvalidAttributesException;
//
//    void delete(Long id) throws NotFoundException;
//
//    GroupEntity addUser(Long id, Long idUser);
//
//    GroupEntity deleteUser(Long id, Long idUser);
//
//    GroupEntity addRoom(Long id, Long idRoom);
//
//    GroupEntity deleteRoom(Long id, Long idRoom);
//}
