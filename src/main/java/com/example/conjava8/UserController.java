package com.example.conjava8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public User addUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String birthdate,
            @RequestParam boolean status) {
        System.out.println(name);
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);

        user.setBirthdate(LocalDate.parse(birthdate));

        user.setStatus(status);
        userRepository.save(user);
        System.out.println(user);
        return user;
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        System.out.println("get all users");
        return userRepository.findAll();
    }
}
