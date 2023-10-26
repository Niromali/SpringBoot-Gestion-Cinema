package com.epg.gc.entities;

import java.util.Collection;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Cinema {
	@jakarta.persistence.Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double longtitude;
	private double lattitude;
	private long altitude;
	private int nombreSalles;
	@OneToMany(mappedBy="cinema")
	private Collection<Salle> salles;
	@ManyToOne
	private Ville ville;
}
