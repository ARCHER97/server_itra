package com.itransition.portfl.service;

import com.itransition.portfl.model.User;
import com.itransition.portfl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Kulik Artur
 */
@Service
@Transactional
public class UserServiceImpl implements  UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
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
}
