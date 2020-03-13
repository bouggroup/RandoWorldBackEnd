package com.heducap.RandoWorldBackEndFinal.metier.projections;

import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

import com.heducap.RandoWorldBackEndFinal.metier.Itineraire;
import com.heducap.RandoWorldBackEndFinal.metier.Randonnee;

@Projection(name = "RandonneeComplet", types = Randonnee.class)
public interface RandonneeComplet extends RandonneeInterface {
	public  Set<Itineraire> getItineraires();
}
