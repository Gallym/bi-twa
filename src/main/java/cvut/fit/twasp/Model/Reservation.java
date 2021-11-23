package cvut.fit.twasp.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reservation", nullable = false)
    private Long id;

    @Column(name = "r_date", nullable = false)
    @JsonFormat(pattern="dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "approved", nullable = false)
    private boolean approved;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Room room;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User attendee;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonBackReference
//    @JoinColumn(name = "id_user", nullable = false)
//    private User author;

    public Long getId() {
        return id;
    }


    public void set(Reservation reservation) {
        this.approved = reservation.approved;
        this.room = reservation.room;
        this.attendee = reservation.attendee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isApproved() {
        return approved;
    }

    public String isApprovedString() {
        return approved ? "Approved" : "Not approved";
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getAttendee() {
        return attendee;
    }

    public void setAttendee(User attendee) {
        this.attendee = attendee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (approved != that.approved) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (room != null ? !room.equals(that.room) : that.room != null) return false;
        return attendee != null ? attendee.equals(that.attendee) : that.attendee == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (approved ? 1 : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (attendee != null ? attendee.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", date=" + date +
                ", approved=" + approved +
                ", room=" + room +
                ", attendee=" + attendee +
                '}';
    }
}
