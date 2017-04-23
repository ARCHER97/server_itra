package com.itransition.portfl.repository;

import com.itransition.portfl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kulik Artur
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
