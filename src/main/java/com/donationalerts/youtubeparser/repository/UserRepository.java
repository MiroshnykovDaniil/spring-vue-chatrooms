package com.donationalerts.youtubeparser.repository;

import com.donationalerts.youtubeparser.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User,Long> {
}
