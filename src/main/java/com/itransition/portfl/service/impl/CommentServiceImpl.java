package com.itransition.portfl.service.impl;

import com.itransition.portfl.dto.CommentDTO;
import com.itransition.portfl.model.Comment;
import com.itransition.portfl.repository.CommentRepository;
import com.itransition.portfl.repository.ImageRepository;
import com.itransition.portfl.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Kulik Artur
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    private ImageRepository imageRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ImageRepository imageRepository){
        this.commentRepository = commentRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public List<Comment> findAllByImageId(Integer id) {
        return this.commentRepository.findAllByImageId(id);
    }

    @Override
    public List<Comment> findAll() {
        return this.commentRepository.findAll();
    }

    @Override
    public void save(CommentDTO commentDTO) {
        Comment comment = commentDTO.toCommentWithoutImage();
        comment.setImage(this.imageRepository.findOne(commentDTO.getImageId()));
        this.commentRepository.save(comment);
    }

    @Override
    public void delete(Integer id) {
        this.commentRepository.delete(id);
    }
}
