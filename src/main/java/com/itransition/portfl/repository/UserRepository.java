package com.itransition.portfl.repository;

import com.itransition.portfl.model.Sex;
import com.itransition.portfl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Kulik Artur
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT p FROM User p WHERE p.id = ?1")
    Sex findOneUserById(Integer id);

}
