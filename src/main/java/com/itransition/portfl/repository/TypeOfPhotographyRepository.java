package com.itransition.portfl.repository;

import com.itransition.portfl.model.TypeOfPhotography;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kulik Artur
 */
@Repository
public interface TypeOfPhotographyRepository extends CrudRepository<TypeOfPhotography, Integer> {

}
