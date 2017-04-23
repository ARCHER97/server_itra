package com.itransition.portfl.repository;

import com.itransition.portfl.model.Image;
import com.itransition.portfl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Kulik Artur
 */
public interface ImageRepository extends JpaRepository<Image, Integer> {

    List<Image> findByProfile(User user);

    @Query("SELECT i FROM Image as i WHERE i.profile.id = :id")
    List<Image> findAllByProfileId(@Param("id") Integer id);

    @Query("SELECT i FROM Image as i WHERE i.position = 1 AND i.profile.id = :id")
    Image findByIdProfileInPosition1(@Param("id") Integer id);
}
