package cvut.fit.twasp.Service.Impl;

import cvut.fit.twasp.Model.Reservation;
import cvut.fit.twasp.Model.Role;
import cvut.fit.twasp.Model.Room;
import cvut.fit.twasp.Model.User;
import cvut.fit.twasp.Repository.ReservationRepo;
import cvut.fit.twasp.Repository.RoomRepo;
import cvut.fit.twasp.Service.ReservationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepo reservationRepo;

    @Autowired
    private RoomRepo roomRepo;

    @Override
    public List<Reservation> findAll() {
        List<Reservation> list = new ArrayList<>();
        reservationRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Reservation findById(Long id) throws NotFoundException {
        Optional<Reservation> reservation = reservationRepo.findById(id);
        if (reservation.isEmpty()) { throw new NotFoundException("User with that id do not exists"); }
        return reservation.get();
    }

    @Override
    public Reservation save(User user, Date date, String roomName) throws InvalidAttributesException {
        Reservation reservation = new Reservation();
        reservation.setAttendee(user);
        reservation.setDate(date);
        reservation.setRoom(roomRepo.findRoomByName(roomName).get());

        //        if (!user.getRoom().equals(reservation.getRoom())) {
//            throw new InvalidAttributesException("User: " + user.toString() + "cannot book room: " + reservation.getRoom().toString());
//        }
        return reservationRepo.save(reservation);
    }

    @Override
    public Reservation update(User user, Long id, Reservation reservation) throws NotFoundException, InvalidAttributesException {
        Reservation reservationOld = findById(id);
        reservationOld.set(reservation);
        return reservationRepo.save(reservationOld);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        reservationRepo.delete(findById(id));
    }

    @Override
    public List<Reservation> getUsersReservations(User user) {
        return getUsersReservations(user.getId());
    }

    @Override
    public List<Reservation> getUsersReservations(Long userId)  {
        List<Reservation> list = new ArrayList<>();
        reservationRepo.getReservationsByAttendee_Id(userId).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<Reservation> getAllUnapprovedForManager(User user_manager) {
        List<Reservation> unapproved = new ArrayList<>();
        List<Room> managersRooms = new ArrayList<>();
        // get managers rooms
        if (user_manager.getRoles().contains(Role.ROOM_MANAGER)) {
            roomRepo.getRoomsByManager_Id(user_manager.getId()).iterator().forEachRemaining(managersRooms::add);
        } /*else if ((user_manager.getRoles().contains(Role.GROUP_MANAGER))) {
            roomRepo.getRoomsByGroup_Id(user_manager.getGroup().getId()).iterator().forEachRemaining(managersRooms::add);
        } */else if (user_manager.getRoles().contains(Role.ADMIN)) {
            roomRepo.findAll().iterator().forEachRemaining(managersRooms::add);
        }
        // add unapproved reservations
        for (Room room: managersRooms) {
            room.getReservations().forEach(reservation -> {if (!reservation.isApproved()) unapproved.add(reservation);});
        }
        return unapproved;
    }

    @Override
    public void approveReservation(User user, Long id) throws NotFoundException {
        Reservation reservation = findById(id);
        reservation.setApproved(true);
        reservationRepo.save(reservation);
    }
}
