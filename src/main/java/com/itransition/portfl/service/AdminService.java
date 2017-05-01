package com.itransition.portfl.service;

import com.itransition.portfl.model.notdbmodel.UserInfoForAdmin;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author Kulik Artur
 */
public interface AdminService {
    List<UserInfoForAdmin> getAdminInfo();

    List<UserInfoForAdmin> getAdminInfoWithCheckAdmin(UserDetails userDetails);

    void updateAdminInfo(List<UserInfoForAdmin> list);

    void updateAdminInfoWithCheckAdmin(List<UserInfoForAdmin> list, UserDetails userDetails);
}

