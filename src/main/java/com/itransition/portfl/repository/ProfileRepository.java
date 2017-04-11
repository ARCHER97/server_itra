package com.itransition.portfl.repository;

import com.itransition.portfl.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Kulik Artur
 */
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    @Query(value = "SELECT p FROM Profile p WHERE p.user.id = ?1")
    Profile findByUserId(Integer id);

}
