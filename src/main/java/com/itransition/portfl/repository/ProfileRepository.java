package com.itransition.portfl.repository;

import com.itransition.portfl.model.Profile;
import com.itransition.portfl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Kulik Artur
 */
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Profile findByUser(User user);

    Profile findByUserId(Integer id);

    Profile findById(Integer id);

    @Query("SELECT p.rating FROM Profile p WHERE p.user.id = :id")
    Integer findRatingByUserId(Integer id);
}
