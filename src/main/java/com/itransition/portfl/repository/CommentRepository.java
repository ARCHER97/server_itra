package com.itransition.portfl.repository;

import com.itransition.portfl.model.Comment;
import com.itransition.portfl.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Kulik Artur
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByImage(Image image);

    List<Comment> findAllByImageId(Integer id);
}
