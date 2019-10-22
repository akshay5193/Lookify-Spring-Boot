package com.akshay.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.akshay.lookify.models.Lookify;
import com.akshay.lookify.services.LookifyService;

@Controller
public class SongsController {
	
	private final LookifyService lookifyService;
	
	public SongsController (LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	
	@GetMapping (value = "/")
	public String landingPage () {
		return "/lookify/landingPage.jsp";
	}
	
	@GetMapping ("/dashboard")
	public String dashboard(@ModelAttribute ("song") Lookify lookify, Model model) {
		List <Lookify> songs = lookifyService.findAll();
		model.addAttribute("songs", songs);
		return "/lookify/dashboard.jsp";
	}
	
	@GetMapping (value="/songs/new") 
	public String newSong (@ModelAttribute ("song") Lookify song) {
		return "/lookify/newSong.jsp";
	}
	
	
	@PostMapping (value="/dashboard")
	public String addNewSong(@Valid @ModelAttribute ("song") Lookify song, BindingResult result) {
		if(result.hasErrors()) {
			return "/lookify/newSong.jsp";
		}
		else {
			lookifyService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	
	@GetMapping (value="/songs/{id}")
	public String showSong(@PathVariable ("id") Long id, Model model) {
		Lookify song = lookifyService.findSong(id);
		model.addAttribute("song", song);
		return "/lookify/viewSong.jsp";
	}
	
	
	@RequestMapping (value="/songs/{id}", method=RequestMethod.DELETE)
	public String deleteSong(@PathVariable ("id") Long id) {
		lookifyService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	
	@GetMapping (value="/search")
	public String artistSongs(@RequestParam (value="artist") String artist, Model model) {
		List <Lookify> artistSongs = lookifyService.getArtistSongs(artist);
		model.addAttribute("artistSongs", artistSongs);
		System.out.println(artistSongs);
		return "/lookify/artist.jsp";
	}
	
	
	@GetMapping (value="/topTen")
	public String topTenSongs(Model model) {
		List<Lookify> topTenSongs = lookifyService.topTenSongs();
		model.addAttribute("topTenSongs", topTenSongs);
		return "/lookify/topTen.jsp";
	}
	
}
