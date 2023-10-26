package com.epg.gc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.epg.gc.entities.FilmProjection;
@RepositoryRestResource
public interface FilmProjectionRepository extends JpaRepository<FilmProjection, Long> {

}
