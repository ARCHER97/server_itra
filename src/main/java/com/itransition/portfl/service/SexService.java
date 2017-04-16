package com.itransition.portfl.service;


import com.itransition.portfl.model.Sex;

/**
 * @author Kulik Artur
 */
public interface SexService {
    Iterable<Sex> findAll();
    Sex findById(Integer id);
    void save(Sex sex);
    void delete(Integer id);
}
