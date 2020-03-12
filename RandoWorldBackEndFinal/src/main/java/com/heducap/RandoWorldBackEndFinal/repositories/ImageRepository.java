package com.heducap.RandoWorldBackEndFinal.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.heducap.RandoWorldBackEndFinal.metier.Image;

public interface ImageRepository extends PagingAndSortingRepository<Image, Integer> {

}
