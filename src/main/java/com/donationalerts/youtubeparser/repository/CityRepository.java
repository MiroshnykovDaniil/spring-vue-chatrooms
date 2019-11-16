package com.donationalerts.youtubeparser.repository;

import com.donationalerts.youtubeparser.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CityRepository extends CrudRepository<City, Long> {
}