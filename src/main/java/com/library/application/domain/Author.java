package com.library.application.domain;

//import java.time.Year;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Author extends Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	String name;
	String surname;
	Integer yearBirth;
	Integer yearDeath;
	
	public Author(String name, String surname, Integer yearBirth, Integer yearDeath) {
		super();
		this.name = name;
		this.surname = surname;
		this.yearBirth = yearBirth;
		this.yearDeath = yearDeath;
		}

	public Author() {
		// TODO Auto-generated constructor stub
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



}
