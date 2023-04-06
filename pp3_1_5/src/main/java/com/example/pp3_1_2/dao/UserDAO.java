package com.example.pp3_1_2.dao;


import com.example.pp3_1_2.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(int id);

    User getUser(int id);
}
