package com.library.application.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity (name = "countries")// This tells Hibernate to make a table out of this class
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	/*
	 * @ManyToOne private Country owner;
	 */
	
	// ***AFEGIR CAMP EXPPROPIEtARI***
	
	/*
	 * @ManyToMany private Set<Country> borderingCountries;
	 */
	
	/*
	 * @ManyToOne private Country formerOwner;
	 */
	
	/* private Integer numOwnedCountries; */
	


	/* private boolean hasLost = false; */
	
	private Integer numWonGames;
	
	 private double successRate;

	// ****AFEGIR PROPIETAT COLOR (String) ***
	
	/*
	 * public Country(Integer id, String name, Country owner, Set<Country>
	 * borderingCountries) { super(); this.name = name; this.owner = owner;
	 * this.borderingCountries = borderingCountries; }
	 */



	public Country() {
		super();
		//this.numOwnedCountries = 1;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public Country getOwner() { return owner; }
	 * 
	 * public void setOwner(Country owner) { this.owner = owner; }
	 */

	/*
	 * public Set<Country> getBorderingCountries() { return borderingCountries; }
	 * 
	 * public void setBorderingCountries(Set<Country> borderingCountries) {
	 * this.borderingCountries = borderingCountries; }
	 * 
	 * public void addBorderingCountry(Country borderingCountry) {
	 * this.borderingCountries.add(borderingCountry); }
	 */

	public Integer getNumWonGames() {
		return numWonGames;
	}

	public void setNumWonGames(Integer numWonGames) {
		this.numWonGames = numWonGames;
	}
	
	public void addOneWonGame() {
		this.numWonGames++;
	}
	
	public double getSuccessRate() {
		return successRate;
	}

	public void setSuccessRate(double successRate) {
		this.successRate = successRate;
	}

	/*
	 * public boolean isHasLost() { return hasLost; }
	 * 
	 * public void setHasLost(boolean hasLost) { this.hasLost = hasLost; }
	 * 
	 * public Country getFormerOwner() { return formerOwner; }
	 * 
	 * public void setFormerOwner(Country formerOwner) { this.formerOwner =
	 * formerOwner; }
	 * 
	 * public Integer getNumOwnedCountries() { return numOwnedCountries; }
	 * 
	 * public void setNumOwnedCountries(Integer numOwnedCountries) {
	 * this.numOwnedCountries = numOwnedCountries; }
	 */
	
	
}
