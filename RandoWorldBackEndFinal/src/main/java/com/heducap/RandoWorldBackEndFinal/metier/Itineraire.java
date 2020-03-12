package com.heducap.RandoWorldBackEndFinal.metier;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Itineraire {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)private int id;

	private LocalDateTime dateDeCreation;
	private LocalDateTime dateDeModification;
	private String nomDuCreateur;
	@ManyToOne  private Randonnee randonnee;
	@OneToOne(mappedBy = "itineraire")private Image image;
	@OneToOne (mappedBy = "itineraire") private Localisation localisation;
	

}
