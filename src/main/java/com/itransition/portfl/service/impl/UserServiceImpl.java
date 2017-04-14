package com.itransition.portfl.service.impl;

import com.itransition.portfl.dto.UserDTO;
import com.itransition.portfl.model.User;
import com.itransition.portfl.model.UsersRoles;
import com.itransition.portfl.repository.RoleRepositiry;
import com.itransition.portfl.repository.UserRepository;
import com.itransition.portfl.repository.UsersRolesRepository;
import com.itransition.portfl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Kulik Artur
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UsersRolesRepository usersRolesRepository;
    private RoleRepositiry roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UsersRolesRepository usersRolesRepository, RoleRepositiry roleRepository){
        this.userRepository = userRepository;
        this.usersRolesRepository = usersRolesRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return this.userRepository.findOne(id);
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        this.userRepository.delete(id);
    }

    @Override
    public void createUser(UserDTO userDTO) {
        User user = userDTO.toUser();
        user = userRepository.save(user);
        this.usersRolesRepository.save(new UsersRoles(user, this.roleRepository.getOne(1)));
    }
}
