package com.itransition.portfl.service.impl;

import com.itransition.portfl.dto.ImageDTO;
import com.itransition.portfl.model.Image;
import com.itransition.portfl.repository.ImageRepository;
import com.itransition.portfl.repository.UserRepository;
import com.itransition.portfl.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
 * @author Kulik Artur
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;

    private UserRepository userRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, UserRepository userRepository){
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Image> findAllByUserId(Integer id) {
        return this.imageRepository.findAllByUserId(id);
    }

    @Override
    public Image findFirstByUserId(Integer id) {
        return this.imageRepository.findByIdUserInPosition1(id);
    }

    @Override
    public void save(ImageDTO imageDTO) {
        Image image = imageDTO.toImageWithoutUser();
        image.setUser(this.userRepository.findOne(imageDTO.getIdImage()));
        this.imageRepository.save(image);
    }

    @Override
    public void delete(Integer id) {
        this.imageRepository.delete(id);
    }
}
