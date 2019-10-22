package com.akshay.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.akshay.lookify.models.Lookify;
import com.akshay.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {

	private final LookifyRepository lookifyRepository;
	
	public LookifyService (LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	
	public List <Lookify> findAll() {
		return lookifyRepository.findAll(); 
	}
	
	public Lookify createSong (Lookify song) {
		return lookifyRepository.save(song);
	}
	
	public Lookify findSong(Long id) {
		Optional<Lookify> optionalSong = lookifyRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
        	System.out.println("no song found");
            return null;
        }
	}
	
	public void deleteSong(Long id) {
		lookifyRepository.deleteById(id);
	}
	
	
	public List<Lookify> getArtistSongs (String artist) {
		List<Lookify> artistSongs = lookifyRepository.findByArtistContaining(artist);
		return artistSongs;
	}
	
	public List<Lookify> topTenSongs () {
		List<Lookify> topTenSongs = lookifyRepository.findByOrderByRatingDesc().subList(0, 10);
		return topTenSongs;
	}
	
}
