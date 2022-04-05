package io.dewe.assignment.service;

import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    io.dewe.assignment.model.User saveUser(io.dewe.assignment.model.User user);

    Optional<io.dewe.assignment.model.User> findByUsername(String username);

    void makeAdmin(Long username);

    void makeAdmin(String username);
}
