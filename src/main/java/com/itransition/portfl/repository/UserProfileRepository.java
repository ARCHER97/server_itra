package com.itransition.portfl.repository;

import com.itransition.portfl.model.Profile;
import com.itransition.portfl.model.User;
import com.itransition.portfl.model.UsersProfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author Kulik Artur
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UsersProfiles, Integer> {

    UsersProfiles findFirstByUserAndProfile(User user, Profile profile);

    @Modifying
    @Transactional
    @Query("UPDATE UsersProfiles u SET u.rating = ?2 WHERE u.id = ?1")
    void updateRatingById(Integer id, Integer rating);
}
