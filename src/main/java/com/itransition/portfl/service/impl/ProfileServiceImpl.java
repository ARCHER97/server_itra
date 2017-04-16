package com.itransition.portfl.service.impl;

import com.itransition.portfl.dto.ProfileDTO;
import com.itransition.portfl.model.Profile;
import com.itransition.portfl.repository.ProfileRepository;
import com.itransition.portfl.repository.SexRepository;
import com.itransition.portfl.repository.TypeOfPhotographyRepository;
import com.itransition.portfl.repository.UserRepository;
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
    private UserRepository userRepository;
    private SexRepository sexRepository;
    private TypeOfPhotographyRepository typeOfPhotographyRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository, UserRepository userRepository,
                              SexRepository sexRepository, TypeOfPhotographyRepository typeOfPhotographyRepository){
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.sexRepository = sexRepository;
        this.typeOfPhotographyRepository = typeOfPhotographyRepository;
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
    public Integer save(ProfileDTO profileDTO) {
        Profile profile = profileDTO.toProfileWithoutUserSexTypeOfPhotography();
        profile.setUser(this.userRepository.findOne(profileDTO.getIdUser()));
        profile.setSex(this.sexRepository.findOne(profileDTO.getIdSex()));
        profile.setTypeOfPhotography(this.typeOfPhotographyRepository.findOne(profileDTO.getIdTypeOfPhotography()));
        this.profileRepository.save(profile);
        return this.profileRepository.findByUserId(profile.getUser().getId()).getId();
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
