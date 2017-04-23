package com.itransition.portfl.service.impl;

import com.itransition.portfl.dto.ProfileDTO;
import com.itransition.portfl.dto.UserDTO;
import com.itransition.portfl.model.Role;
import com.itransition.portfl.model.User;
import com.itransition.portfl.model.UsersRoles;
import com.itransition.portfl.repository.RoleRepositiry;
import com.itransition.portfl.repository.UsersRolesRepository;
import com.itransition.portfl.service.AuthService;
import com.itransition.portfl.service.ProfileService;
import com.itransition.portfl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kulik Artur
 */
@Service
//@Transactional
public class AuthServiviceImpl implements AuthService {

    private UserService userService;
    private ProfileService profileService;
    private UsersRolesRepository usersRolesRepository;
    private RoleRepositiry roleRepositiry;

    @Autowired
    public AuthServiviceImpl(UserService userService, ProfileService profileService,
                             UsersRolesRepository usersRolesRepository, RoleRepositiry roleRepositiry) {
        this.userService = userService;
        this.profileService = profileService;
        this.usersRolesRepository = usersRolesRepository;
        this.roleRepositiry = roleRepositiry;
    }

    @Override
    public boolean login(UserDTO userDTO) {
        User user = userDTO.toUser();
        try {
            this.userService.loadUserByUsername(user.getUsername());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean singup(UserDTO userDTO, ProfileDTO profileDTO) {
        User user = userDTO.toUser();
        try {
            this.userService.loadUserByUsername(user.getUsername());
        } catch (Exception e) {
            user = this.userService.save(user);
            saveProfile(user.getId(), profileDTO);
            saveUserRole(user, this.roleRepositiry.findOne(1));
            return true;
        }
        return false;
    }

    private void saveProfile(Integer id, ProfileDTO profileDTO) {
        profileDTO.setIdUser(id);
        profileDTO.setColLike(0);
        profileDTO.setRating(0.0);
        this.profileService.save(profileDTO);
    }

    private void saveUserRole(User user, Role role) {
        this.usersRolesRepository.save(new UsersRoles(user, role));
    }

}
