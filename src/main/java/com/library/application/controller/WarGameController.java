package com.library.application.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;

import com.library.application.domain.Country;
import com.library.application.domain.WarGame;
import com.library.application.persistence.CountryRepository;
import com.library.application.persistence.WarGameRepository;
import com.library.exception.ResourceNotFoundException;


@Controller	// This means that this class is a Controller
@CrossOrigin //(origins = "http://library")
@RequestMapping(path="/wargame") // This means URL's start with /demo (after Application path)
public class WarGameController {
	
	/*
	 * @Autowired private MovementRepository movementRepository;
	 */
	
	@Autowired 
	private CountryRepository countryRepository;
	
	@Autowired 
	private WarGameRepository warGameRepository;
	
	
	//private Movement movement;
	
	//WarGame warGame;
	
	//Country country;
	
	@PostMapping("/new")
	//@GetMapping("/new")
	@ResponseBody
	public Integer createGame()  { 
		
		WarGame wargame = new WarGame();
	//	wargame.setRemainingCountries(42);
		warGameRepository.save(wargame);
		
//	Iterable<Country> allCountries = countryRepository.findAll();
	
//	Country nobody = null;
	
		/*
		 * for (Country c : allCountries) { if (c.getId()==43) { nobody = c;
		 * 
		 * } }
		 */
	
		/*
		 * for (Country c : allCountries) {
		 * 
		 * //c.setOwner(c); //c.setFormerOwner(c); //c.setNumOwnedCountries(1);
		 * //c.setHasLost(false); countryRepository.save(c);
		 * 
		 * }
		 */
		
	//	return wargame;
		return wargame.getId();
		
	}
	

	@PostMapping("/winner/{idWarGame}/{winnerId}")
	//@GetMapping("/new/{idWarGame}")
	@ResponseBody
	public Integer setWinner(@PathVariable (value = "idWarGame") Integer idWarGame, @PathVariable (value = "winnerId") Integer winnerId)  {


		
		ArrayList<Integer> wargamesIds = new ArrayList<Integer>();
		
		wargamesIds.add(idWarGame);
		
		List<WarGame> thisWargame;
		
		thisWargame = warGameRepository.findAllById(wargamesIds);
		
		ArrayList<Integer> countriesIds = new ArrayList<Integer>();
		
		countriesIds.add(winnerId);
		
		Iterable<Country> thisCountry;
		
		thisCountry = countryRepository.findAllById(countriesIds);
		
		

		
		
		for(Country c: thisCountry){
			thisWargame.get(0).setWinner(c);
		//	thisWargame.get(0).setRemainingCountries(0);
			thisWargame.get(0).getWinner().addOneWonGame();
		}
		
	 warGameRepository.save(thisWargame.get(0));
	 
	 
	 //Update stats
	 
	 double totalGamesPlayed = 0;
		
		Iterable<Country> allCountries = countryRepository.findAll();
	 
	 for (Country c: allCountries) {
		 if (c.getNumWonGames() != null) {
			 totalGamesPlayed+=(double)(c.getNumWonGames());
		 }
	 }
	 

	 
	 for (Country d: allCountries) {
		 double numWonGames =  (double)(d.getNumWonGames());
		 
		 double successRate = numWonGames/totalGamesPlayed*100;
		 
		 successRate = Math.round(successRate * 100);
		 successRate = successRate/100;
		 d.setSuccessRate(successRate);
		 countryRepository.save(d);
	 }
	 	 
	// countryRepository.saveAll(allCountries);
	
	 //returns id winner
	
	 return thisWargame.get(0).getWinner().getId();
		
		

	}
	
	@GetMapping("/stats")
	@ResponseBody
	public Iterable<Country> getStats()  {
		Iterable<Country> allCountries = countryRepository.findAll();
		

		
		return allCountries;
		
		

	}
}