package com.itransition.portfl.service;

import com.itransition.portfl.model.Sex;
import com.itransition.portfl.repository.SexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Artur on 10.04.2017.
 */
@Service
public class SexServiceImpl implements  SexService {
    private SexRepository sexRepository;

    @Autowired
    public SexServiceImpl(SexRepository sexRepository){
        this.sexRepository = sexRepository;
    }

    public List<Sex> findAll() {
        return sexRepository.findAll();
    }

    public Sex findOneSexById(Integer id) {
        return sexRepository.findOneSexById(id);
    }

    public void save(Sex sex) {
        sexRepository.save(sex);
    }

    public void deleteSexById(Integer id) {
        sexRepository.delete(id);
    }
}
