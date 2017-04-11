package com.itransition.portfl.service;

import com.itransition.portfl.model.Sex;
import com.itransition.portfl.repository.SexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Kulik Artur
 */
@Service
@Transactional
public class SexServiceImpl implements  SexService {

    private SexRepository sexRepository;

    @Autowired
    public SexServiceImpl(SexRepository sexRepository){
        this.sexRepository = sexRepository;
    }

    public List<Sex> findAll() {
        return sexRepository.findAll();
    }

    public Sex findById(Integer id) {
        return sexRepository.findById(id);
    }

    public void save(Sex sex) {
        sexRepository.save(sex);
    }

    public void delete(Integer id) {
        sexRepository.delete(id);
    }
}
