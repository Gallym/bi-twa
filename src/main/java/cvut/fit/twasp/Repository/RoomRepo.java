package cvut.fit.twasp.Repository;

import cvut.fit.twasp.Model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepo extends CrudRepository<Room, Long> {
    Iterable<Room> getRoomsByManager_Id(Long id);
//    Iterable<Room> getRoomsByGroup_Id(Long id);
    Optional<Room> findRoomByName(String name);

}
