package com.heducap.RandoWorldBackEndFinal.metier.projections;

import java.time.LocalDateTime;

import org.springframework.data.rest.core.config.Projection;

import com.heducap.RandoWorldBackEndFinal.metier.Randonnee;

@Projection(name = "RandonneeInterface", types = Randonnee.class)
public interface RandonneeInterface {
	
	public String getNom();
	public String getDescription();
	public String getOrganisateur();
	public LocalDateTime getDateDeCreation();
	public LocalDateTime getDateDeDeroulement();	

}
