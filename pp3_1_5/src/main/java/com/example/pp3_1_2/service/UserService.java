package com.example.pp3_1_2.service;


import com.example.pp3_1_2.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);

    void deleteUser(int id);
    User getUser(int id);

    User findUserByEmail(String email);
}
