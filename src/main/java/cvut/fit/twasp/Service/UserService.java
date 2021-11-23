package cvut.fit.twasp.Service;

import cvut.fit.twasp.Model.User;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.directory.InvalidAttributesException;
import java.util.List;

@Service
@Transactional
public interface UserService {
    List<User> findAll();

    User findById(Long id) throws NotFoundException;

    User save(User user) throws InvalidAttributesException;

    User update(Long id, User user) throws NotFoundException, InvalidAttributesException;

    void delete(Long id) throws NotFoundException;

    User findByEmail(String email) throws NotFoundException;

    // User findByName(String name) throws NotFoundException;

    //User findBySurname(String name) throws NotFoundException;
}
