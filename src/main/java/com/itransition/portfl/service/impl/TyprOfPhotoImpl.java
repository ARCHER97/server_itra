package com.itransition.portfl.service.impl;

import com.itransition.portfl.model.TypeOfPhotography;
import com.itransition.portfl.repository.TypeOfPhotographyRepository;
import com.itransition.portfl.service.TypeOfPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kulik Artur
 */
@Service
public class TyprOfPhotoImpl implements TypeOfPhotoService {

    private TypeOfPhotographyRepository typeOfPhotographyRepository;

    @Autowired
    public TyprOfPhotoImpl(TypeOfPhotographyRepository typeOfPhotographyRepository) {
        this.typeOfPhotographyRepository = typeOfPhotographyRepository;
    }

    @Override
    public Iterable<TypeOfPhotography> findAll() {
        return this.typeOfPhotographyRepository.findAll();
    }

    @Override
    public TypeOfPhotography findById(Integer id) {
        return this.typeOfPhotographyRepository.findOne(id);
    }

    @Override
    public void save(TypeOfPhotography typeOfPhotography) {
        this.typeOfPhotographyRepository.save(typeOfPhotography);
    }

    @Override
    public void delete(Integer id) {
        this.typeOfPhotographyRepository.delete(id);
    }

}
