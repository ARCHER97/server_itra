package com.itransition.portfl.repository;

import com.itransition.portfl.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Artur on 09.04.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
