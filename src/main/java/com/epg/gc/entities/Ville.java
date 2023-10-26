package com.epg.gc.entities;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Ville {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double longtitude;
	private double lattitude;
	private double altitude;
	private int nombrehabitant;
	@OneToMany(mappedBy="ville")
	private Collection<Cinema> cinemas;
}
