package cvut.fit.twasp.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "user_entity")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "phone", nullable = true)
    private String phone;

    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "id_user"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @JsonIgnore
    @OneToMany(mappedBy = "attendee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Reservation> reservations;

//    @JsonIgnore
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Reservation> reservations;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_occupies_rooms",
            joinColumns = { @JoinColumn(name = "fk_user") },
            inverseJoinColumns = { @JoinColumn(name = "fk_room") })
    private Set<Room> rooms;

    @JsonIgnore
    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Room> managed_rooms;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonBackReference
//    @JoinColumn(name = "id_group", nullable = true)
//    private GroupEntity group;

    // TODO: join same column twice
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonBackReference
//    @JoinColumn(name = "id_group", nullable = true)
//    private GroupEntity manages_group;


    public User() {
    }

    public User(String name, String surname, String email, String password, String phone, boolean active) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    // TODO: validate
    public void set(User user) {
        this.name = user.name;
        this.surname = user.surname;
        this.email = user.email;
        this.password = user.password;
        this.phone = user.phone;
        this.roles = user.roles;
        this.reservations = user.reservations;
        this.rooms = user.rooms;
        this.managed_rooms = user.managed_rooms;
//        this.group = user.group;
        //this.manages_group = user.manages_group;
    }

//    public boolean isAdmin() {
//        return this.roles.contains(Role.ADMIN);
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    public void setUsername(String username) {
        this.email = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Set<Room> getManaged_rooms() {
        return managed_rooms;
    }

    public void setManaged_rooms(Set<Room> managed_rooms) {
        this.managed_rooms = managed_rooms;
    }

//    public GroupEntity getGroup() {
//        return group;
//    }

//    public void setGroup(GroupEntity group) {
//        this.group = group;
//    }
    public boolean isActive() {
        return active;
    }

    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

//    @Override
//    public String toString() {
//
//        StringBuilder str = new StringBuilder("User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", phone='" + phone + '\'' +
//                ", active=" + active +
//                ", reservations=" + reservations.toString() +
//                //", rooms=" + rooms.toString() +
//                ", room=" + room.toString() +
//                ", managed_rooms=" + managed_rooms.toString() +
//                ", roles={");
//                for (Role r : roles) {
//                    str.append(r.toString());
//                    str.append(", ");
//                }
//                str.append("default}");
//                str.append('}');
//        return str.toString();
//    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", active=" + active +
                ", roles=" + roles +
               // ", reservations=" + reservations +
                //", rooms=" + rooms +
                ", managed_rooms=" + managed_rooms +
                '}';
    }
}
