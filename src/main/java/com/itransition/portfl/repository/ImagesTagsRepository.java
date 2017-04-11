package com.itransition.portfl.repository;

import com.itransition.portfl.model.ImagesTags;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kulik Artur
 */
public interface ImagesTagsRepository extends JpaRepository<ImagesTags, Integer> {
}
