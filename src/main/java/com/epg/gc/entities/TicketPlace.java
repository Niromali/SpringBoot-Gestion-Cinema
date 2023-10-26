package com.epg.gc.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class TicketPlace {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private double prix;
	private String nomclient;
	@Column(unique=true,nullable = true)
	private Integer codepayement;
	private boolean reservee;
	@ManyToOne
	private FilmProjection filmprojection;
	@ManyToOne
	private Place place;
}
