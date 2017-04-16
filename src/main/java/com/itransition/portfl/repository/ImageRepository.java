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

    List<Image> findByUser(User user);

    List<Image> findAllByUserId(Integer id);

    @Query("SELECT i FROM Image as i WHERE i.position = :position AND i.user.id = 1")
    Image findByIdUserInPosition1(@Param("id") Integer id);
}
