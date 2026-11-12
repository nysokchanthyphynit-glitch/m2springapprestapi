package kh.edu.istad.m2springrestapi.service;

import kh.edu.istad.m2springrestapi.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> getAll();
    User getById(UUID id);
    User create(User user);
    boolean delete(UUID id);
}
