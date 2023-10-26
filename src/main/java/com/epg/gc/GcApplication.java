package com.epg.gc;

import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epg.gc.data.ServiceInitData;
import com.epg.gc.entities.Film;
import com.epg.gc.entities.Ville;
import com.epg.gc.repository.CategorieRepository;
import com.epg.gc.repository.FilmRepository;
import com.epg.gc.repository.VilleRepository;

@SpringBootApplication
public class GcApplication implements CommandLineRunner{
	
	@Autowired
	ServiceInitData serviceInitData;
	public static void main(String[] args) {	
		SpringApplication.run(GcApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		initData();
		
	}
	private void initData() {
		// TODO Auto-generated method stub
		serviceInitData.initCategorie();
		serviceInitData.initFilm();
		serviceInitData.initVille();
		
		serviceInitData.initCinema();
		serviceInitData.initSalle();
		serviceInitData.initPlace();
		
		serviceInitData.initSeance();
		serviceInitData.initFilmProjection();
		serviceInitData.initTicketPlace();
	}

}
