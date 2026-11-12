package kh.edu.istad.m2springrestapi.repository;


import kh.edu.istad.m2springrestapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {
    private final List<User> users;
    public UserRepository(){
        users = new ArrayList<>();
        User usrAdmin = new User(UUID.randomUUID(), "Administrator", "admin", "qwer", true);
        User usrEditor = new User(UUID.randomUUID(), "Editor", "editor", "qwer", false);
        User usrCustomer = new User(UUID.randomUUID(), "Chov Rathliza", "liza", "qwer", true);
        users.add(usrAdmin);
        users.add(usrEditor);
        users.add(usrCustomer);
    }
    public List<User> selectAll(){
        return users;
    }
    public Optional<User> selectById(UUID id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst(); }
    public void insert(User user) {
        users.add(user);
    }
    public boolean deleteById(UUID id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}

