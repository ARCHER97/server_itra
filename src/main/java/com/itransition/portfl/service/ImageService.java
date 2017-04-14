package com.itransition.portfl.service;

import com.itransition.portfl.model.Image;

import java.util.List;

/**
 * @author Kulik Artur
 */
public interface ImageService {
    List<Image> findAllByUserId(Integer id);
    Image findFirstByUserId(Integer id);
    void save(Image image);
    void delete(Integer id);
}
