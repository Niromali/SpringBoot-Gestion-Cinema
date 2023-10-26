package com.epg.gc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.epg.gc.entities.Film;
@RepositoryRestResource
public interface FilmRepository extends JpaRepository<Film, Long> {

}
