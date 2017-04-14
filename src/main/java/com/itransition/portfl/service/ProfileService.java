package com.itransition.portfl.service;

import com.itransition.portfl.model.Profile;

/**
 * @author Kulik Artur
 */
public interface ProfileService {
    Profile findByUserId(Integer id);
    Profile findById(Integer id);
    void save(Profile profile);
    void delete(Integer id);
    Integer findRatingByUserId(Integer id);
}
