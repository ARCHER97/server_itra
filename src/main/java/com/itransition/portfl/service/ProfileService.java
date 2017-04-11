package com.itransition.portfl.service;

import com.itransition.portfl.model.Profile;

/**
 * Created by Artur on 10.04.2017.
 */
public interface ProfileService {
    Profile findByUserId(Integer id);
    void save(Profile profile);
    void delete(Integer id);
}
