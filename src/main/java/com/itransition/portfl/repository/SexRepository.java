package com.itransition.portfl.repository;

import com.itransition.portfl.model.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Artur on 09.04.2017.
 */
@Repository
public interface SexRepository extends JpaRepository<Sex, Integer> {
    @Query(value = "SELECT p FROM Sex p WHERE p.id = ?1")
    Sex findOneSexById(Integer id);

    @Modifying
    @Query(value = "DELETE FROM Sex p WHERE p.id = ?1")
    void delete(Integer id);
}
