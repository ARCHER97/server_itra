package com.itransition.portfl.service;

import com.itransition.portfl.model.TypeOfPhotography;

/**
 * @author Kulik Artur
 */
public interface TypeOfPhotoService {
    Iterable<TypeOfPhotography> findAll();
    TypeOfPhotography findById(Integer id);
    void save(TypeOfPhotography typeOfPhotography);
    void delete(Integer id);
}
