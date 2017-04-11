package com.itransition.portfl.service;

import com.itransition.portfl.model.Profile;
import com.itransition.portfl.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Kulik Artur
 */
@Service
@Transactional
public class ProfileServiceImpl implements ProfileService{

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
    public void save(Profile profile) {
        this.profileRepository.save(profile);
    }

    @Override
    public void delete(Integer id) {
        this.profileRepository.delete(id);
    }
}
