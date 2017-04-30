package com.itransition.portfl.repository;

import com.itransition.portfl.model.ImagesTags;
import com.itransition.portfl.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Kulik Artur
 */
public interface ImagesTagsRepository extends JpaRepository<ImagesTags, Integer> {

    @Query("SELECT it.tag FROM ImagesTags it WHERE it.image.id = :id")
    List<Tag> findAllByImageId(@Param("id") Integer id);

}
