package cvut.fit.twasp.Service;

import cvut.fit.twasp.Model.Reservation;
import cvut.fit.twasp.Model.User;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.naming.directory.InvalidAttributesException;
import java.util.Date;
import java.util.List;

@Service
public interface ReservationService {
    List<Reservation> findAll();

    Reservation findById(Long id) throws NotFoundException;

    Reservation save(User user, Date date, String roomName) throws InvalidAttributesException;

    Reservation update(User user, Long id, Reservation reservation) throws NotFoundException, InvalidAttributesException;

    void delete(Long id) throws NotFoundException;

    //List<Reservation> getAllByUserId(Long userId) throws NotFoundException;

    //Reservation getOneByUserById(Long id_user, Long id_reservation);

    List<Reservation> getUsersReservations(User user);

    List<Reservation> getUsersReservations(Long userId);

    List<Reservation> getAllUnapprovedForManager(User user_manager);

    void approveReservation(User user, Long id) throws NotFoundException;
}
