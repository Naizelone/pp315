package com.example.pp3_1_2;

import com.example.pp3_1_2.entity.Status;
import com.example.pp3_1_2.entity.User;
import com.example.pp3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

import static com.example.pp3_1_2.entity.Role.ADMIN;
import static com.example.pp3_1_2.entity.Role.USER;

@SpringBootApplication
public class Pp312Application {

    private final UserService userService;
    @Autowired
    public Pp312Application(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void addUserDB(){
        //log = admin@mail.com
        //password = admin
        userService.saveUser(new User("Admin","Admin",33,"admin@mail.com",
                "$2y$12$lflcRQsD7QCd.zzPSOEkNuLA6ugCGtpqmqrHdWS.6WCPKw1NXOrqu",
                ADMIN, Status.ACTIVE));
        //pass = user
        userService.saveUser(new User("User","Userov",33,"user@mail.com",
                "$2y$12$9MZ/9gr52mbsxPxRzkV8GO2pZxpt2jRuZmmDWgQVX5m1O.1waymty",
                USER, Status.ACTIVE));
        //pass = user
        userService.saveUser(new User("Banned","Banned",33,"banned@mail.com",
                "$2y$12$9MZ/9gr52mbsxPxRzkV8GO2pZxpt2jRuZmmDWgQVX5m1O.1waymty",
                USER, Status.BANNED));
    }

    public static void main(String[] args) {
        SpringApplication.run(Pp312Application.class, args);
    }

}
