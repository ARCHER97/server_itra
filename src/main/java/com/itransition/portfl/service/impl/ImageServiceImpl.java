package com.itransition.portfl.service.impl;

import com.itransition.portfl.dto.ArrayImagesDTO;
import com.itransition.portfl.dto.ImageDTO;
import com.itransition.portfl.model.Image;
import com.itransition.portfl.repository.ImageRepository;
import com.itransition.portfl.repository.ProfileRepository;
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

    private ProfileRepository profileRepository;

    private UserRepository userRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository,
                            ProfileRepository profileRepository,
                            UserRepository userRepository) {
        this.imageRepository = imageRepository;
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Image> findAllByProfileId(Integer id) {
        return this.imageRepository.findAllByProfileId(id);
    }

    @Override
    public Image findFirstByUserId(Integer id) {
        return this.imageRepository.findByIdProfileInPosition1(id);
    }

    @Override
    public Integer save(ImageDTO imageDTO) {
        Image image = imageDTO.toImageWithoutProfile();
        image.setProfile(this.profileRepository.findOne(imageDTO.getIdProfile()));
        image = this.imageRepository.save(image);
        return image.getId();
    }

    @Override
    public Integer saveNext(ImageDTO imageDTO) {
        Image image = imageDTO.toImageWithUrl();
        image.setProfile(this.profileRepository.findOne(imageDTO.getIdProfile()));
        Integer nextPosition = this.imageRepository.findImageWhereMaxPosition(imageDTO.getIdProfile()) + 1;
        image.setPosition(nextPosition);
        image = this.imageRepository.save(image);
        return image.getId();
    }

    @Override
    public void delete(Integer id) {
        this.imageRepository.delete(id);
    }

    @Override
    public void saveAll(ArrayImagesDTO arrayImagesDTO) {
        List<Image> list = arrayImagesDTO.getImages();
        for (Image image : list) {
            this.imageRepository.updatePositionOfImage(image.getId(), image.getPosition());
        }
    }
}
