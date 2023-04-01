package com.example.pp3_1_2.controller;

import com.example.pp3_1_2.entity.User;
import com.example.pp3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
//@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showAllUsers(Model model){
        List<User> userList = userService.getAllUsers();
        model.addAttribute(userList);
        return "adminPanel";
    }

    @RequestMapping("/addUser")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        System.out.println(user.getRole());
        return "userCreate";
    }

    @RequestMapping("saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/admin/";
    }

    @RequestMapping("/updateInfo")
    public String updateUser(@ModelAttribute("user") User user, Model model) {
        userService.saveUser(user);
        return "redirect:/admin/";
    }

    @RequestMapping("/deleteInfo")
    public String deleteUser(@RequestParam("userId") int id){
        userService.deleteUser(id);
        return "redirect:/admin/";
    }

}
