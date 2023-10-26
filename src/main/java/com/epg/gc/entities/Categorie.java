package com.epg.gc.entities;

import java.util.Collection;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Categorie {
	@jakarta.persistence.Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(length = 60)
	private String name;
	@OneToMany(mappedBy="categorie")
	private Collection<Film> films;
}
