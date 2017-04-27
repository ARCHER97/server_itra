package com.itransition.portfl.service;

import com.itransition.portfl.dto.AddRatingInfoDTO;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Kulik Artur
 */
public interface RatingService {
    public void addRating(AddRatingInfoDTO addRatingInfoDTO, UserDetails userDetails);
}
