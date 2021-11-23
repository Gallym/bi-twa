package cvut.fit.twasp.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_room", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy="rooms", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> users;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Building building;

    @JsonIgnore
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Reservation> reservations;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User manager;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonBackReference
//    @JoinColumn(name = "id_group", nullable = true)
//    private GroupEntity group;

    public Room() {
    }

    public Room(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }
//
//    public GroupEntity getGroup() {
//        return group;
//    }
//
//    public void setGroup(GroupEntity group) {
//        this.group = group;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        return id != null ? id.equals(room.id) : room.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

//    @Override
//    public String toString() {
//        return "Room{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", users=" + users.toString() +
//                ", building=" + building.toString() +
//                ", reservations=" + reservations.toString() +
//                ", manager=" + manager.toString() +
//                ", group=" + group.toString() +
//                '}';
//    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", users=" + users +
                ", building=" + building +
                //", reservations=" + reservations +
                ", manager=" + manager +
                '}';
    }

    public void set(Room room) {
        this.name = room.name;
        this.users = room.users;
        this.building = room.building;
        this.reservations = room.reservations;
        this.manager = room.manager;
      //  this.group = room.group;
    }
}
