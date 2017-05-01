package com.itransition.portfl.repository;

import com.itransition.portfl.model.Role;
import com.itransition.portfl.model.User;
import com.itransition.portfl.model.UsersRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author Kulik Artur
 */
public interface UsersRolesRepository extends JpaRepository<UsersRoles, Integer> {

    UsersRoles getUsersRolesByUser(User user);

    @Modifying
    @Transactional
    @Query("update UsersRoles ur set ur.role = ?2 where ur.user = ?1")
    void update(User user, Role role);

}
