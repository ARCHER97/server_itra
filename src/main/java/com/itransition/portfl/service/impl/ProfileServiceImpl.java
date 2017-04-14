package com.itransition.portfl.service.impl;

import com.itransition.portfl.model.Profile;
import com.itransition.portfl.repository.ProfileRepository;
import com.itransition.portfl.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Kulik Artur
 */
@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile findByUserId(Integer id) {
        return this.profileRepository.findByUserId(id);
    }

    @Override
    public Profile findById(Integer id) {
        return this.profileRepository.findById(id);
    }

    @Override
    public void save(Profile profile) {
        this.profileRepository.save(profile);
    }

    @Override
    public void delete(Integer id) {
        this.profileRepository.delete(id);
    }

    @Override
    public Integer findRatingByUserId(Integer id) {
        return this.profileRepository.findRatingByUserId(id);
    }

}
