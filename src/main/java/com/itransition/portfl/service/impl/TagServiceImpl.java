package com.itransition.portfl.service.impl;

import com.itransition.portfl.model.Tag;
import com.itransition.portfl.repository.ImagesTagsRepository;
import com.itransition.portfl.repository.TagRepository;
import com.itransition.portfl.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Kulik Artur
 */
@Service
@Transactional
public class TagServiceImpl implements TagService {

    private TagRepository tagRepository;
    private ImagesTagsRepository imagesTagsRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository, ImagesTagsRepository imagesTagsRepository){
        this.tagRepository = tagRepository;
        this.imagesTagsRepository = imagesTagsRepository;
    }

    @Override
    public List<Tag> findAll() {
        return this.tagRepository.findAll();
    }

    @Override
    public Tag findById(Integer id) {
        return this.tagRepository.findOne(id);
    }

    @Override
    public List<Tag> findByImageId(Integer id) {
        return this.imagesTagsRepository.findAllByImageId(id);
    }

    @Override
    public void save(Tag tag) {
        this.tagRepository.save(tag);
    }

    @Override
    public void delete(Integer id) {
        this.tagRepository.delete(id);
    }
}
