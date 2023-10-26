package com.epg.gc.entities;

import java.util.Collection;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
public class Film {
	@jakarta.persistence.Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String realisateur;
	private String description;
	private String photo;
	private int durre;
	@OneToMany(mappedBy="film")
	private Collection<FilmProjection> filmprojections;
	@ManyToOne
	private Categorie categorie;
	
}
