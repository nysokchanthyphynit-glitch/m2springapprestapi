package kh.edu.istad.m2springrestapi.service.impl;


import kh.edu.istad.m2springrestapi.model.User;
import kh.edu.istad.m2springrestapi.repository.UserRepository;
import kh.edu.istad.m2springrestapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.selectAll();
    }


    @Override
    public User getById(UUID id) {
        return userRepository.selectById(id)
                .orElseThrow();
    }
    @Override
    public User create(User user) {
        user.setId(UUID.randomUUID());
        userRepository.insert(user);
        return user;
    }
    @Override

    public boolean delete(UUID id) {
        return userRepository.deleteById(id);
    }
}
