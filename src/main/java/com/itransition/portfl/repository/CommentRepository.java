package com.itransition.portfl.repository;

import com.itransition.portfl.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Kulik Artur
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "SELECT i FROM Comment i WHERE i.image.id = ?1")
    List<Comment> findAllByImageId(Integer id);

}
