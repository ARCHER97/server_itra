package com.itransition.portfl.service.impl;

import com.itransition.portfl.model.notdbmodel.Top;
import com.itransition.portfl.repository.ImageRepository;
import com.itransition.portfl.repository.ProfileRepository;
import com.itransition.portfl.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * @author Kulik Artur
 */
@Service
@Transactional
public class TopServiceImpl implements TopService{

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
        list.add(new Top("1",0,"url1"));
        list.add(new Top("2",0,"url2"));
        list.add(new Top("3",0,"url3"));
        return list;
    }
}
