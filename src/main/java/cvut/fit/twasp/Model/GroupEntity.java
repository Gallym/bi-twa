//package cvut.fit.twasp.Model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "group_entity")
//public class GroupEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id_group", nullable = false)
//    private Long id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
////    @JsonIgnore
////    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
////    @JoinColumn(name = "id_user", nullable = true)
////    private Set<User> users;
//
////    @JsonIgnore
////    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
////    @JoinColumn(name = "id_user", nullable = true)
////    private Set<User> managers;
//
//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_room", nullable = true)
//    private Set<Room> rooms;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
////    public Set<User> getUsers() {
////        return users;
////    }
////
////    public void setUsers(Set<User> users) {
////        this.users = users;
////    }
//
////    public Set<User> getManagers() {
////        return managers;
////    }
////
////    public void setManagers(Set<User> managers) {
////        this.managers = managers;
////    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        GroupEntity that = (GroupEntity) o;
//
//        return id != null ? id.equals(that.id) : that.id == null;
//    }
//
//    @Override
//    public int hashCode() {
//        return id != null ? id.hashCode() : 0;
//    }
//
//    @Override
//    public String toString() {
//        return "GroupEntity{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                //", users=" + users +
//               // ", managers=" + managers +
//                ", rooms=" + rooms +
//                '}';
//    }
//}
