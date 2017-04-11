package com.itransition.portfl.service;

import com.itransition.portfl.model.User;

import java.util.List;

/**
 * @author Kulik Artur
 */
public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    void save(User user);
    void delete(Integer id);
}