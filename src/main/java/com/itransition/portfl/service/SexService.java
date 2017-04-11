package com.itransition.portfl.service;

import com.itransition.portfl.model.Sex;

import java.util.List;

/**
 * @author Kulik Artur
 */
public interface SexService {
    List<Sex> findAll();
    Sex findById(Integer id);
    void save(Sex post);
    void delete(Integer id);
}
