package com.heducap.RandoWorldBackEndFinal.metier;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter  @NoArgsConstructor
@Entity
public class Randonnee {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)private int id;
	private String nom;
	private String description;
	private String organisateur;
	private LocalDateTime dateDeCreation;
	private LocalDateTime dateDeDeroulement;
	@JsonIgnore @OneToMany (mappedBy = "randonnee") private Set<Itineraire> itineraires;
	
	public Randonnee(int id, String nom, String description, String organisateur, LocalDateTime dateDeCreation,
			LocalDateTime dateDeDeroulement) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.organisateur = organisateur;
		this.dateDeCreation = dateDeCreation;
		this.dateDeDeroulement = dateDeDeroulement;
	}
	

}
