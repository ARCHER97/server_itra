package com.itransition.portfl.repository;

import com.itransition.portfl.model.Profile;
import com.itransition.portfl.model.Sex;
import com.itransition.portfl.model.TypeOfPhotography;
import com.itransition.portfl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author Kulik Artur
 */
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Profile findByUser(User user);

    Profile findByUserId(Integer id);

    Profile findById(Integer id);

    @Query("SELECT p.rating FROM Profile p WHERE p.user.id = :id")
    Integer findRatingByUserId(Integer id);

    @Modifying
    @Transactional
    @Query("update Profile p set p.rating = ?1, p.colLike = ?2 where p.id = ?3")
    void updateRating(Double rating, Integer colLike, Integer idProfile);

    @Modifying
    @Transactional
    @Query("update Profile p set p.sex = ?2, p.typeOfPhotography = ?3, p.name = ?4, " +
            "p.yearOfBirth = ?5, p.height = ?6, p.weight = ?7 where p.id = ?1")
    void update(Integer id, Sex sex, TypeOfPhotography typeOfPhotography, String name, Integer yearOfBirth,
                Integer height, Integer weight);
}
