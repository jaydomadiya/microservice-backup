package com.userservice.service.Service;

import com.userservice.service.Entity.User;

import java.util.List;

public interface UserMicroService {

    User saveUser(User user);

    List<User> getAllUsers();
    User getUserById(Integer userId);



}
