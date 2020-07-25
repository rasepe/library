package com.library.application.domain;

//import java.time.Year;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Collaborator extends Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	String name;
	String surname;
	Integer yearBirth;
	Integer yearDeath;
	
	// @OneToMany(fetch = FetchType.LAZY)  
	//private Set<Function> functions;
private Function function;
	
	public Collaborator(String name, String surname, Integer yearBirth, Integer yearDeath, Function function) {
		super();
		this.name = name;
		this.surname = surname;
		this.yearBirth = yearBirth;
		this.yearDeath = yearDeath;
		this.function = function;
	}
	
	public Collaborator() {
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getYearBirth() {
		return yearBirth;
	}

	public void setYearBirth(Integer yearBirth) {
		this.yearBirth = yearBirth;
	}

	public Integer getYearDeath() {
		return yearDeath;
	}

	public void setYearDeath(Integer yearDeath) {
		this.yearDeath = yearDeath;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}




	

	
	
}
