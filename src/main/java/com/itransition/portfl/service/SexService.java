package com.itransition.portfl.service;

import com.itransition.portfl.model.Sex;

import java.util.List;

/**
 * Created by Artur on 10.04.2017.
 */
public interface SexService {
    List<Sex> findAll();
    Sex findOneSexById(Integer id);
    void save(Sex post);
    void deleteSexById(Integer id);
}
