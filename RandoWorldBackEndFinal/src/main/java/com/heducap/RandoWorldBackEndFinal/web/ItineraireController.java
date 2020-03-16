package com.heducap.RandoWorldBackEndFinal.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.RouteMatcher.Route;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heducap.RandoWorldBackEndFinal.metier.Itineraire;
import com.heducap.RandoWorldBackEndFinal.repositories.ItineraireRepository;

@RestController
@RequestMapping("/itineraires")
@CrossOrigin
public class ItineraireController {
	@Autowired
	private ItineraireRepository itineraireRepository;

	
	@GetMapping
	public Page<Itineraire> findAll(@PageableDefault(page = 0, size = 8) Pageable page){
		return this.itineraireRepository.findAll(page);
	}
	
	
	
	@PostMapping("/insert")
	public ResponseEntity<Itineraire> createItineraire(
			@RequestBody Itineraire itineraire){
		itineraire = itineraireRepository.save(itineraire);
		return new ResponseEntity<Itineraire>(itineraire, HttpStatus.CREATED);
	}
	
}
