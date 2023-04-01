package com.example.pp3_1_2.controller;

import com.example.pp3_1_2.entity.User;
import com.example.pp3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class Rest {
    private final UserService userService;
    @Autowired
    public Rest(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize ("hasAuthority('USER')")
    @GetMapping ("/user/api")
    public User getUserPage(Principal principal) {
        User user = userService.findUserByEmail(principal.getName());
        System.out.println(user.toString());
        return user;
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
@GetMapping ("/admin/userList")
public List<User> show(){
    List<User> userList = userService.getAllUsers();
    System.out.println(userList.toString());
    return userList;
}

    @PostMapping ("/admin/save")
    public void saveUser(@RequestBody User user) {
        System.out.println("user in save " + user.toString());
        userService.saveUser(user);
    }

    @PutMapping ("/admin/edit")
    public void editUser(@RequestBody User user) {
        System.out.println("user in edit " + user.toString());
        userService.saveUser(user);
    }

    @DeleteMapping("/admin/delete/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }


}
