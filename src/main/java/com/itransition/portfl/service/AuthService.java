package com.itransition.portfl.service;

import com.itransition.portfl.dto.ImageDTO;
import com.itransition.portfl.dto.ProfileDTO;
import com.itransition.portfl.dto.UserDTO;

/**
 * @author Kulik Artur
 */
public interface AuthService {

    boolean login(UserDTO userDTO);

    boolean singup(UserDTO userDTO, ProfileDTO profileDTO, ImageDTO imageDTO);

}
