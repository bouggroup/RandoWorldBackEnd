package com.heducap.RandoWorldBackEndFinal.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.heducap.RandoWorldBackEndFinal.metier.Randonnee;

@RepositoryRestResource
public interface RandonneeRepository extends PagingAndSortingRepository<Randonnee, Integer> {

}
