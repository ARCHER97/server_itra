package com.itransition.portfl.service.impl;

import com.itransition.portfl.dto.TagDTO;
import com.itransition.portfl.model.ImagesTags;
import com.itransition.portfl.model.Tag;
import com.itransition.portfl.repository.ImageRepository;
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
    private ImageRepository imageRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository, ImagesTagsRepository imagesTagsRepository,
                          ImageRepository imageRepository) {
        this.tagRepository = tagRepository;
        this.imagesTagsRepository = imagesTagsRepository;
        this.imageRepository = imageRepository;
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
    public void save(TagDTO tagDTO) {
        Tag tag = this.tagRepository.findFirstByText(tagDTO.getText());
        if (tag == null) {
            tag = this.tagRepository.save(tagDTO.toTag());
        }
        ImagesTags imagesTags = new ImagesTags(this.imageRepository.findOne(tagDTO.getIdImage()), tag);
        this.imagesTagsRepository.save(imagesTags);
    }

    @Override
    public void saveAll(List<TagDTO> tagsDTO) {
        int i = 0;
        for (TagDTO tagDTO: tagsDTO) {
            this.save(tagsDTO.get(i));
            i++;
        }
    }

    @Override
    public void delete(Integer id) {
        this.tagRepository.delete(id);
    }
}
