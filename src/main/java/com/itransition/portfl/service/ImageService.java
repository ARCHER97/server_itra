package com.itransition.portfl.service;

import com.itransition.portfl.dto.ArrayImagesDTO;
import com.itransition.portfl.dto.ImageDTO;
import com.itransition.portfl.model.Image;

import java.util.List;

/**
 * @author Kulik Artur
 */
public interface ImageService {
    List<Image> findAllByProfileId(Integer id);

    Image findFirstByUserId(Integer id);

    Integer save(ImageDTO imageDTO);

    Integer saveNext(ImageDTO imageDTO);

    void delete(Integer id);

    void saveAll(ArrayImagesDTO arrayImagesDTO);
}
