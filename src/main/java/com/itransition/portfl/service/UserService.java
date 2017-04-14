package com.itransition.portfl.service;

import com.itransition.portfl.dto.UserDTO;
import com.itransition.portfl.model.User;

/**
 * @author Kulik Artur
 */
public interface UserService {
    Iterable<User> findAll();
    User findById(Integer id);
    void save(User user);
    void delete(Integer id);
    void createUser(UserDTO userDTO);
}
