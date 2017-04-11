package com.itransition.portfl.service;

import com.itransition.portfl.model.Tag;
import com.itransition.portfl.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Kulik Artur
 */
@Service
@Transactional
public class TagServiceImpl implements TagService{

    private TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository){
        this.tagRepository = tagRepository;
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
    public void save(Tag tag) {
        this.tagRepository.save(tag);
    }

    @Override
    public void delete(Integer id) {
        this.tagRepository.delete(id);
    }
}
