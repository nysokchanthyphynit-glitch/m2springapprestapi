package kh.edu.istad.m2springrestapi.controller;


import kh.edu.istad.m2springrestapi.model.User;
import kh.edu.istad.m2springrestapi.repository.UserRepository;
import kh.edu.istad.m2springrestapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;



    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable UUID id){
        return userService.getById(id);
    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User created = userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (!userService.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
