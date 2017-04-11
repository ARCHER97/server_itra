package com.itransition.portfl.service;

import com.itransition.portfl.model.Comment;
import com.itransition.portfl.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Kulik Artur
 */
@Service
@Transactional
public class CommentServiceImpl implements  CommentService{

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAllByImageId(Integer id) {
        return this.commentRepository.findAllByImageId(id);
    }

    @Override
    public void save(Comment comment) {
        this.commentRepository.save(comment);
    }

    @Override
    public void delete(Integer id) {
        this.commentRepository.delete(id);
    }
}
