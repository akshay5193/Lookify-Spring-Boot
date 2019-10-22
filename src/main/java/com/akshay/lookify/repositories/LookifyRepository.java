package com.akshay.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.akshay.lookify.models.Lookify;

public interface LookifyRepository extends CrudRepository <Lookify, Long> {

	List <Lookify> findAll();
	List<Lookify> findByArtistContaining(String search);
	List<Lookify> findByOrderByRatingAsc();
	List<Lookify> findByOrderByRatingDesc();
}
