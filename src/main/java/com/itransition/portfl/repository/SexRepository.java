package com.itransition.portfl.repository;

import com.itransition.portfl.model.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Kulik Artur
 */
@Repository
public interface SexRepository extends JpaRepository<Sex, Integer> {

    @Query(value = "SELECT p FROM Sex p WHERE p.id = ?1")
    Sex findById(Integer id);

}
