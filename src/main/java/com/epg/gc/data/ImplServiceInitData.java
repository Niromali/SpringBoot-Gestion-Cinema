package com.epg.gc.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epg.gc.entities.Categorie;
import com.epg.gc.entities.Cinema;
import com.epg.gc.entities.Film;
import com.epg.gc.entities.FilmProjection;
import com.epg.gc.entities.Place;
import com.epg.gc.entities.Salle;
import com.epg.gc.entities.Seance;
import com.epg.gc.entities.TicketPlace;
import com.epg.gc.entities.Ville;
import com.epg.gc.repository.CategorieRepository;
import com.epg.gc.repository.CinemaRepository;
import com.epg.gc.repository.FilmProjectionRepository;
import com.epg.gc.repository.FilmRepository;
import com.epg.gc.repository.PlaceRepository;
import com.epg.gc.repository.SalleRepository;
import com.epg.gc.repository.SeanceRepository;
import com.epg.gc.repository.TicketPlaceRepository;
import com.epg.gc.repository.VilleRepository;

import jakarta.transaction.Transactional;

@Service
public class ImplServiceInitData implements ServiceInitData {
	@Autowired
	CategorieRepository categorieRepository;
	@Autowired
	FilmRepository filmRepository;
	@Autowired
	VilleRepository villeRepository;
	@Autowired
	CinemaRepository cinemaRepository;
	@Autowired
	SalleRepository salleRepository;
	@Autowired
	PlaceRepository placeRepository;
	@Autowired
	SeanceRepository seanceRepository;
	@Autowired
	FilmProjectionRepository filmProjectionRepository;
	@Autowired
	TicketPlaceRepository ticketPlaceRepository;
	@Override
	public void initCategorie() {
		// TODO Auto-generated method stub
		Stream.of("drama","action","romance").forEach(cat -> {
			Categorie ca=new Categorie();
			ca.setName(cat);
			categorieRepository.save(ca);
		});
	}
	@Override
	public void initVille() {
		// TODO Auto-generated method stub
		Stream.of("fes","meknes","rabat","casa").forEach(villename->{
			Ville v=new Ville();
			v.setName(villename);
			villeRepository.save(v);
		});	
	}
	@Override
	public void initFilm() {
		// TODO Auto-generated method stub
		String [] realisateurs= {"ali","Hassan","Mohammed"};
		int [] durres= {1,3,5};
		Random aleatoir=new Random();
		categorieRepository.findAll().forEach(cat ->{
			Stream.of("film 1","film 2","film 3").forEach(filmName->{
			Film f=new Film();
			f.setCategorie(cat);
			f.setDurre(durres[aleatoir.nextInt(durres.length)]);
			f.setRealisateur(realisateurs[aleatoir.nextInt(realisateurs.length)]);
			f.setTitre(filmName);
			filmRepository.save(f);
			});
		});
	}

	@Override
	public void initSalle() {
		// TODO Auto-generated method stub
		cinemaRepository.findAll().forEach(cinema ->{
				for(int i=0;i<cinema.getNombreSalles();i++) {
					Salle salle=new Salle();
					salle.setName("Salle "+(i+1));
					salle.setNombreplaces(15+((int)(Math.random()*100)));
					salle.setCinema(cinema);
					salleRepository.save(salle);
				}
			});
	}

	@Override
	public void initPlace() {
		// TODO Auto-generated method stub
		salleRepository.findAll().forEach(salle ->{
			for(int i=1;i<=salle.getNombreplaces();i++) {
				Place place=new Place();
				place.setNumeroplace(i);
				place.setSalle(salle);
				placeRepository.save(place);
			}
		});
	}

	

	@Override
	public void initCinema() {
		villeRepository.findAll().forEach(ville ->{
		Stream.of("Megarama","Rex").forEach(cinemaname->{
			Cinema cinema=new Cinema();
			cinema.setName(cinemaname);
			cinema.setNombreSalles(3+((int)(Math.random()*10)));
			cinema.setVille(ville);
			cinemaRepository.save(cinema);
		});	
		});
	}
	
	
	
	@Override
	public void initSeance() {
		DateFormat format = new SimpleDateFormat("HH:mm");
		// TODO Auto-generated method stub
		Stream.of("9:00","12:00","15:00","17:00","20:00").forEach(debutseance->{
			Seance seance=new Seance();
			try {
				seance.setHeuredebut(format.parse(debutseance));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			seanceRepository.save(seance);
		});	
	}

	@Override
	public void initFilmProjection() {
		// TODO Auto-generated method stub
		double [] prix= {90,80,120,150};
	
		seanceRepository.findAll().forEach(seance->{
		filmRepository.findAll().forEach(film->{
			salleRepository.findAll().forEach(salle->{
		
		FilmProjection filmp= new FilmProjection();
		filmp.setDateprojection(new Date());
		filmp.setFilm(film);
		filmp.setPrix(prix[new Random().nextInt(prix.length)]);
		filmp.setSeance(seance);
		filmp.setSalle(salle);
		filmProjectionRepository.save(filmp);
		
		});
		});
		});
	}
	@Override
	@Transactional
	public void initTicketPlace() {
		// TODO Auto-generated method stub
		
		filmProjectionRepository.findAll().forEach(projection->{
			projection.getSalle().getPlaces().forEach(place->{
			TicketPlace ticketplace = new TicketPlace();
			
			ticketplace.setFilmprojection(projection);
			ticketplace.setPlace(place);
			ticketplace.setPrix(projection.getPrix());
			ticketplace.setReservee(false);
			ticketPlaceRepository.save(ticketplace);
		});
		});
		
	}

}
