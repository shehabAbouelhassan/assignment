package io.dewe.assignment.service;

import io.dewe.assignment.model.Role;
import io.dewe.assignment.model.User;

import io.dewe.assignment.repository.IUserRepository;
import jdk.nashorn.internal.ir.Optimistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements  IUserService {

    @Autowired
    private IUserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

///fucking massed up
    @Override
    public org.springframework.security.core.userdetails.User saveUser(org.springframework.security.core.userdetails.User user) {
        return null;
    }

    @Override
    public User saveUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }


    @Override
    public Optional<User> findByUsername(String username){

        return userRepository.findByUsername(username);

    }

    @Override
    public void makeAdmin(Long username) {

    }

    @Override
    @Transactional //Transactional required when executing an update/delete query .
    public void makeAdmin(String username)
    {
        userRepository.updateUserRole(username, Role.ADMIN);
    }
}
