package com.example.pp3_1_2.controller;

import com.example.pp3_1_2.dao.UserRepository;
import com.example.pp3_1_2.entity.User;
import com.example.pp3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
public class UserRestController {
    private final UserService userService;
    private final UserRepository userRepository;
    public UserRestController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @PreAuthorize ("hasAuthority('USER')")
    @GetMapping ("/user/api")
    public Optional<User> getUser(Principal principal) {
        Optional<User> user = userRepository.findByEmail(principal.getName());
        return user;
    }

    @GetMapping ("/admin/userList")
    public List<User> showUserList(){
    List<User> userList = userService.getAllUsers();
    return userList;
}

    @PostMapping ("/admin/save")
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping ("/admin/edit")
    public void editUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @DeleteMapping("/admin/delete/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }


}
