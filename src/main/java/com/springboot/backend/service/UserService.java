package com.springboot.backend.service;

import com.springboot.backend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    User saveUser(User employee);
    List<User> getAllUser();
    User findUser(int id);
    User updateUser(User employee, int id);
    void deleteUser(int id);
}
