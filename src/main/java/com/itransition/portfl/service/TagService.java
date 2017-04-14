package com.itransition.portfl.service;

import com.itransition.portfl.model.Tag;

import java.util.List;

/**
 * @author Kulik Artur
 */
public interface TagService {
    List<Tag> findAll();
    Tag findById(Integer id);
    List<Tag> findByImageId(Integer id);
    void save(Tag tag);
    void delete(Integer id);
}
