package com.library.application.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity (name = "warGames") // This tells Hibernate to make a table out of this class
public class WarGame {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	//private Integer movementCounter;
	
	
	//private Integer remainingCountries; // = 42;
	
	@OneToOne
	private Country winner;

	

	/*
	 * public WarGame(Country winner, Integer remainingCountries) { super();
	 * this.remainingCountries = remainingCountries; this.winner = winner; }
	 */

	public WarGame() {
		super();
		//this.movementCounter = 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Country getWinner() {
		return winner;
	}

	public void setWinner(Country winner) {
		this.winner = winner;
	}
	
	/*
	 * public Integer getRemainingCountries() { return remainingCountries ; }
	 * 
	 * public void setRemainingCountries(Integer remainingCountries) {
	 * this.remainingCountries = remainingCountries; }
	 */
	
	/*
	 * public Integer getMovementCounter() { return movementCounter; }
	 * 
	 * public void setMovementCounter(Integer movementCounter) {
	 * this.movementCounter = movementCounter; }
	 */

}
