package com.itransition.portfl.service.impl;

import com.itransition.portfl.model.Image;
import com.itransition.portfl.model.Profile;
import com.itransition.portfl.model.notdbmodel.Top;
import com.itransition.portfl.repository.ImageRepository;
import com.itransition.portfl.repository.ProfileRepository;
import com.itransition.portfl.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kulik Artur
 */
@Service
@Transactional
public class TopServiceImpl implements TopService {

    private ProfileRepository profileRepository;

    private ImageRepository imageRepository;

    @Autowired
    public TopServiceImpl(ProfileRepository profileRepository, ImageRepository imageRepository){
        this.profileRepository = profileRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public ArrayList<Top> findTop(Integer col){
        ArrayList<Top> list = new ArrayList<>();
        List<Profile> sortProfiles = this.profileRepository.findAll(new Sort("rating"));
        for(int i = 0; i < sortProfiles.size(); i++){
            Image image = this.imageRepository.findByIdProfileInPosition1(sortProfiles.get(i).getId());
            Top top = new Top(sortProfiles.get(i).getId(), sortProfiles.get(i).getName(),
                              sortProfiles.get(i).getRating(), "");
            if(image != null){top.setUrl(image.getUrl());}
            list.add(top);
            if(i>=col) break;
        }
        return list;
    }
}
