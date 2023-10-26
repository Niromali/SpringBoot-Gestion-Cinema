package com.epg.gc.entities;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Place {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int numeroplace;
	private double longtitude;
	private double lattitude;
	private double altitude;
	@ManyToOne
	private Salle salle;
	@OneToMany(mappedBy="place")
	private Collection<TicketPlace> ticketplaces;
}
