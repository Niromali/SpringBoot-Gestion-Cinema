package com.epg.gc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.epg.gc.entities.TicketPlace;
@RepositoryRestResource
public interface TicketPlaceRepository extends JpaRepository<TicketPlace, Long> {

}
