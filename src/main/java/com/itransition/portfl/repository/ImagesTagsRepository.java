package com.itransition.portfl.repository;

import com.itransition.portfl.model.ImagesTags;
import com.itransition.portfl.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Kulik Artur
 */
public interface ImagesTagsRepository extends JpaRepository<ImagesTags,Integer> {

    /**
     * @param id of image
     * @return list of tags 
     */
    @Query("SELECT it.tag FROM ImagesTags it WHERE it.image.id = :id")
    List<Tag> findAllByImageId(Integer id);
}
