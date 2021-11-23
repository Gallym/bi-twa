package cvut.fit.twasp.Service.Impl;

import cvut.fit.twasp.Model.User;
import cvut.fit.twasp.Repository.UserRepo;
import cvut.fit.twasp.Service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.directory.InvalidAttributesException;
import java.util.*;

@Service(value = "UserService")
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepo userRepo;

//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByEmail(username);
//        if(user.isEmpty()){
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), getAuthority(user.get()));
//    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByEmail(username);
        System.out.println("HERE: " + username);
        if (user.isEmpty()) {
            System.out.println(userRepo.findAll().toString());
            throw new UsernameNotFoundException("User with email: " + username + " was not found");
        }
        return user.get();
    }

    @Override
    @Transactional
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    @Transactional
    public User findById(Long id) throws NotFoundException {
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) { throw new NotFoundException("User with that id do not exists"); }
        return user.get();
    }

    @Override
    @Transactional
    public User save(User user)throws InvalidAttributesException {
        return userRepo.save(user);
    }

    @Override
    @Transactional
    public User update(Long id, User user) throws NotFoundException, InvalidAttributesException {
        User userDB = findById(id);
        userDB.set(user);
        return save(userDB);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {
        userRepo.delete(findById(id));
    }

    @Override
    @Transactional
    public User findByEmail(String email) throws NotFoundException {
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isEmpty()) {
            throw new NotFoundException("User with that username do ton exists.");
        }
        return user.get();
    }
}
