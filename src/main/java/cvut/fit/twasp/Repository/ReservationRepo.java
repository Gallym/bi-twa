package cvut.fit.twasp.Repository;

import cvut.fit.twasp.Model.Reservation;
import cvut.fit.twasp.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ReservationRepo extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> getReservationsByAttendeeIs(User attendee);
    Iterable<Reservation> getReservationsByAttendee_Id(Long id);
    Iterable<Reservation> getReservationsByRoom_IdAndApprovedIsFalse(Long id);
}
