package com.itransition.portfl.service.impl;

import com.itransition.portfl.model.Role;
import com.itransition.portfl.repository.RoleRepositiry;
import com.itransition.portfl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kulik Artur
 */
@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepositiry roleRepositiry;

    @Autowired
    public RoleServiceImpl(RoleRepositiry roleRepositiry) {
        this.roleRepositiry = roleRepositiry;
    }

    @Override
    public List<Role> getAll() {
        return roleRepositiry.findAll();
    }

}
