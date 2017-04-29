package com.itransition.portfl.repository;

import com.itransition.portfl.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kulik Artur
 */
public interface TagRepository extends JpaRepository<Tag, Integer> {
    Tag findFirstByText(String text);
}
