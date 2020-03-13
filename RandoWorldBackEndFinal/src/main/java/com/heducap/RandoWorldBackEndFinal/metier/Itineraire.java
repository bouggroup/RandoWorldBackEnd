package com.heducap.RandoWorldBackEndFinal.metier;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class Itineraire {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)private int id;

	private LocalDateTime dateDeCreation;
	private LocalDateTime dateDeModification;
	private String nomDuCreateur;
	@ManyToOne @JsonIgnore  private Randonnee randonnee;
	
	@OneToOne(mappedBy = "itineraire") private Image image;
	
	@OneToOne (mappedBy = "itineraire") private Localisation localisation;

	public Itineraire(int id, LocalDateTime dateDeCreation, LocalDateTime dateDeModification, String nomDuCreateur,
			Randonnee randonnee) {
		super();
		this.id = id;
		this.dateDeCreation = dateDeCreation;
		this.dateDeModification = dateDeModification;
		this.nomDuCreateur = nomDuCreateur;
		this.randonnee = randonnee;
	}
	
	
	

}
