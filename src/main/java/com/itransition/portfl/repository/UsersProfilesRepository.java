package com.itransition.portfl.repository;

import com.itransition.portfl.model.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kulik Artur
 */
public interface UsersProfilesRepository extends JpaRepository<Sex, Integer> {
}