package com.itransition.portfl.service.impl;

import com.itransition.portfl.dto.CommentDTO;
import com.itransition.portfl.model.Comment;
import com.itransition.portfl.model.Profile;
import com.itransition.portfl.repository.CommentRepository;
import com.itransition.portfl.repository.ImageRepository;
import com.itransition.portfl.repository.ProfileRepository;
import com.itransition.portfl.repository.UserRepository;
import com.itransition.portfl.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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

    private UserRepository userRepository;

    private ProfileRepository profileRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ImageRepository imageRepository,
                              UserRepository userRepository, ProfileRepository profileRepository) {
        this.commentRepository = commentRepository;
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
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
    public void saveNext(CommentDTO commentDTO, UserDetails userDetails) {
        Comment comment = commentDTO.toCommentWithoutImage();
        if (userDetails != null) {
            Profile profile = this.profileRepository
                    .findByUser(this.userRepository.findByLogin(userDetails.getUsername()));
            comment.setTitle(profile.getName());
        } else comment.setTitle("anonimus");
        comment.setImage(this.imageRepository.findOne(commentDTO.getImageId()));
        Integer pizdec = this.commentRepository.findCommentWhereMaxPosition(commentDTO.getImageId());
        if (pizdec == null) pizdec = 0;
        comment.setPosition(pizdec + 1);

        this.commentRepository.save(comment);
    }

    @Override
    public void delete(Integer id) {
        this.commentRepository.delete(id);
    }
}
