package cvut.fit.twasp.Service.Impl;

import cvut.fit.twasp.Model.Reservation;
import cvut.fit.twasp.Model.Room;
import cvut.fit.twasp.Repository.RoomRepo;
import cvut.fit.twasp.Service.RoomService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.directory.InvalidAttributesException;
import java.util.*;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepo roomRepo;

    @Override
    @Transactional
    public List<Room> findAll() {
        List<Room> list = new ArrayList<>();
        roomRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    @Transactional
    public Room findById(Long id) throws NotFoundException {
        Optional<Room> room = roomRepo.findById(id);
        if (room.isEmpty()) { throw new NotFoundException("Room with that id do not exists"); }
        return room.get();
    }

    @Override
    @Transactional
    public Room save(Room room) throws InvalidAttributesException {
        return roomRepo.save(room);
    }

    @Override
    @Transactional
    public Room update(Long id, Room room) throws NotFoundException, InvalidAttributesException {
        Room roomDB = findById(id);
        roomDB.set(room);
        return save(roomDB);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {
        roomRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Room findByName(String name) throws NotFoundException {
        Optional<Room> room = roomRepo.findRoomByName(name);
        if (room.isEmpty()) {
            throw new NotFoundException("Room with name: " + name + " was not found");
        }
        return room.get();
    }

    @Override
    @Transactional
    public List<Room> findAllAvailable(Date date) {
        List<Room> allRooms = findAll();
        Iterator<Room> itRoom = allRooms.iterator();
        Room room;
        Set<Reservation> reservations;
        while (itRoom.hasNext()) {
            room = itRoom.next();
            reservations = room.getReservations();
            for (Reservation reservation : reservations) {
                if (reservation.getDate() == date) {
                    itRoom.remove();
                }
            }
        }
        return allRooms;
    }
}
