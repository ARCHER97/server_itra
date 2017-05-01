package com.itransition.portfl.service.impl;

import com.itransition.portfl.model.Profile;
import com.itransition.portfl.model.Role;
import com.itransition.portfl.model.User;
import com.itransition.portfl.model.notdbmodel.UserInfoForAdmin;
import com.itransition.portfl.repository.ProfileRepository;
import com.itransition.portfl.repository.RoleRepositiry;
import com.itransition.portfl.repository.UserRepository;
import com.itransition.portfl.repository.UsersRolesRepository;
import com.itransition.portfl.service.AdminService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kulik Artur
 */
@NoArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private ProfileRepository profileRepository;
    private UserRepository userRepository;
    private UsersRolesRepository usersRolesRepository;
    private RoleRepositiry roleRepositiry;

    @Autowired
    public AdminServiceImpl(ProfileRepository profileRepository, UserRepository userRepository,
                            UsersRolesRepository usersRolesRepository, RoleRepositiry roleRepositiry) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.usersRolesRepository = usersRolesRepository;
        this.roleRepositiry = roleRepositiry;
    }

    @Override
    public List<UserInfoForAdmin> getAdminInfo() {
        List<User> users = this.userRepository.findAll();
        List<UserInfoForAdmin> userInfoForAdminList = new ArrayList<>();
        for (User user : users) {
            userInfoForAdminList.add(this.create(user));
        }
        return userInfoForAdminList;
    }

    @Override
    public List<UserInfoForAdmin> getAdminInfoWithCheckAdmin(UserDetails userDetails) {
        User user = this.userRepository.findByLogin(userDetails.getUsername());
        Role role = this.usersRolesRepository.getUsersRolesByUser(user).getRole();
        if(role.getRolename().equals("ROLE_ADMIN")){
            return this.getAdminInfo();
        }
        return new ArrayList<>();
    }

    @Override
    public void updateAdminInfo(List<UserInfoForAdmin> list) {
        for (UserInfoForAdmin userInfoForAdmin : list) {
            this.update(userInfoForAdmin);
        }
    }

    @Override
    public void updateAdminInfoWithCheckAdmin(List<UserInfoForAdmin> list, UserDetails userDetails) {
        User user = this.userRepository.findByLogin(userDetails.getUsername());
        Role role = this.usersRolesRepository.getUsersRolesByUser(user).getRole();
        if(role.getRolename().equals("ROLE_ADMIN")){
            this.updateAdminInfo(list);
        }
    }

    private UserInfoForAdmin create(User user) {
        Profile profile = this.profileRepository.findByUser(user);
        Role role = this.usersRolesRepository.getUsersRolesByUser(user).getRole();
        return new UserInfoForAdmin(user.getId(), profile.getName(), profile.getColLike(), profile.getRating(), role);
    }

    private void update(UserInfoForAdmin userInfoForAdmin) {
        Role role = this.roleRepositiry.findFirstByRolename(userInfoForAdmin.getRole().getRolename());
        User user = this.userRepository.findOne(userInfoForAdmin.getId());
        this.usersRolesRepository.update(user, role);
    }

}
