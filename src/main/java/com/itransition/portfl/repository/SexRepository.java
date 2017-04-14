package com.itransition.portfl.repository;

import com.itransition.portfl.model.Sex;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexRepository extends CrudRepository<Sex, Integer> {
}
