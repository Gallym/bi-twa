package cvut.fit.twasp.Service;

import cvut.fit.twasp.Model.Room;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.naming.directory.InvalidAttributesException;
import java.util.Date;
import java.util.List;

@Service
public interface RoomService {
    List<Room> findAll();

    Room findById(Long id) throws NotFoundException;

    Room save(Room room) throws InvalidAttributesException;

    Room update(Long id, Room room) throws NotFoundException, InvalidAttributesException;

    void delete(Long id) throws NotFoundException;

    Room findByName(String name) throws NotFoundException;

    List<Room> findAllAvailable(Date date);
}
