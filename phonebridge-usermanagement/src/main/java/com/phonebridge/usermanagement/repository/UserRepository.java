package com.phonebridge.usermanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.phonebridge.usermanagement.model.User;

/**
* Phone Bridge user repository 
*
* @author  Vinoth Manoharan
* @version 1.0
* @since   06-March-2020 
*/

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends MongoRepository<User, String> {
	//List<User> findByLastName(@Param("name") String name);
}
