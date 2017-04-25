package com.itransition.portfl.service;

import com.itransition.portfl.dto.TagDTO;
import com.itransition.portfl.model.Tag;

import java.util.List;

/**
 * @author Kulik Artur
 */
public interface TagService {
    List<Tag> findAll();
    Tag findById(Integer id);
    List<Tag> findByImageId(Integer id);
    void save(TagDTO tagDTO);
    void saveAll(List<TagDTO> tags);
    void delete(Integer id);
}
