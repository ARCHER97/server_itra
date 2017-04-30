package com.itransition.portfl.repository;

import com.itransition.portfl.model.User;
import com.itransition.portfl.model.UsersRoles;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kulik Artur
 */
public interface UsersRolesRepository extends JpaRepository<UsersRoles, Integer>{

    UsersRoles getUsersRolesByUser(User user);

}
