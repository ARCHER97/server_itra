package com.itransition.portfl.service;

import com.itransition.portfl.model.Comment;

import java.util.List;

/**
 * @author Kulik Artur
 */
public interface CommentService {
    List<Comment> findAllByImageId(Integer id);
    void save(Comment comment);
    void delete(Integer id);
}
