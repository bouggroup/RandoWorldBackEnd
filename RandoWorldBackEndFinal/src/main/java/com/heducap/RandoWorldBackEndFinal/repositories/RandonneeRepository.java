package com.heducap.RandoWorldBackEndFinal.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.heducap.RandoWorldBackEndFinal.metier.Randonnee;

public interface RandonneeRepository extends PagingAndSortingRepository<Randonnee, Integer> {

}
