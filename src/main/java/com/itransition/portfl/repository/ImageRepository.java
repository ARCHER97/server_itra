package com.itransition.portfl.repository;

import com.itransition.portfl.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Kulik Artur
 */
public interface ImageRepository extends JpaRepository<Image, Integer> {

    @Query(value = "SELECT i FROM Image i WHERE i.user.id = ?1")
    List<Image> findAllByUserId(Integer id);

}
