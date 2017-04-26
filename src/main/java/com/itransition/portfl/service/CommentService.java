package com.itransition.portfl.service;

import com.itransition.portfl.dto.CommentDTO;
import com.itransition.portfl.model.Comment;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author Kulik Artur
 */
public interface CommentService {
        List<Comment> findAllByImageId(Integer id);
        List<Comment> findAll();
        void save(CommentDTO commentDTO);
        void saveNext(CommentDTO commentDTO, UserDetails userDetails);
        void delete(Integer id);
}
