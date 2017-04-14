package com.itransition.portfl.service.impl;

import com.itransition.portfl.model.Image;
import com.itransition.portfl.repository.ImageRepository;
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

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }

    @Override
    public List<Image> findAllByUserId(Integer id) {
        return this.imageRepository.findAllByUserId(id);
    }

    @Override
    public Image findFirstByUserId(Integer id) {
        return this.imageRepository.findByIdUserAndPosition(id, 1);
    }

    @Override
    public void save(Image image) {
        this.imageRepository.save(image);
    }

    @Override
    public void delete(Integer id) {
        this.imageRepository.delete(id);
    }
}
