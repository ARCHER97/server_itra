package com.itransition.portfl.repository;

import com.itransition.portfl.model.Image;
import com.itransition.portfl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Kulik Artur
 */
public interface ImageRepository extends JpaRepository<Image, Integer> {

    List<Image> findByProfile(User user);

    @Query("SELECT i FROM Image as i WHERE i.profile.id = :id ORDER BY i.position")
    List<Image> findAllByProfileId(@Param("id") Integer id);

    @Query("SELECT i FROM Image as i WHERE i.position = 1 AND i.profile.id = :id")
    Image findByIdProfileInPosition1(@Param("id") Integer id);

    @Query("SELECT max(i.position) FROM Image as i WHERE i.profile.id = :id")
    Integer findImageWhereMaxPosition(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("update Image i set i.position = ?2 where i.id = ?1")
    void updatePositionOfImage(Integer id, Integer position);
}
