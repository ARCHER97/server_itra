package com.itransition.portfl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itransition.portfl.model.notdbmodel.UserInfoForAdmin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Kulik Artur
 */
@NoArgsConstructor
@Getter
@Setter
public class ArrayUserInfoForAdminDTO {

    private List<UserInfoForAdmin> userInfoForAdminArrayList;

    public ArrayUserInfoForAdminDTO(@JsonProperty("users") List<UserInfoForAdmin> userInfoForAdminList) {
        this.userInfoForAdminArrayList = userInfoForAdminList;
    }

}
