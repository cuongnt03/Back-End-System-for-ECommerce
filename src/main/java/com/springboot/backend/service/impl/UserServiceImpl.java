package com.springboot.backend.service.impl;

import com.springboot.backend.entity.User;
import com.springboot.backend.exception.ResourceNotFoundException;
import com.springboot.backend.repository.UserRepository;
import com.springboot.backend.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUser(int id) {
        return  userRepository.findById(id).orElseThrow();
    }

    @Override
    public User updateUser(User user, int id) {
        User exsistingEmployee = userRepository.findById(id).orElseThrow();
        exsistingEmployee.setFullname(user.getFullname());
        exsistingEmployee.setBirthday(user.getBirthday());
        exsistingEmployee.setGender(user.isGender());
        exsistingEmployee.setPhone(user.getPhone());
        exsistingEmployee.setEmail(user.getEmail());
        exsistingEmployee.setImg(user.getImg());

        //save existing employee to database
        userRepository.save(exsistingEmployee);

        return exsistingEmployee;
    }

    @Override
    public void deleteUser(int id) {
        userRepository.findById(id).orElseThrow();
        userRepository.deleteById(id);
    }
}
