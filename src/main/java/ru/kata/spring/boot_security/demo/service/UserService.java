package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User add(User user);
    boolean update(User user);
    boolean removeById(Long id);
    List<User> findAll();
    Optional<User> findById(Long id);
}
