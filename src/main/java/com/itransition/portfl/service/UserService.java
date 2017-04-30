package com.itransition.portfl.service;

import com.itransition.portfl.dto.UserDTO;
import com.itransition.portfl.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

/**
 * @author Kulik Artur
 */
public interface UserService extends UserDetailsService {
    Iterable<User> findAll();

    User findById(Integer id);

    Optional<User> findUser(Integer id);

    User save(User user);

    void delete(Integer id);

    User createUser(UserDTO userDTO);

    boolean isAdmin(UserDetails userDetails);
}
