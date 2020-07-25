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

@Entity // This tells Hibernate to make a table out of this class
public class WRelationship {
	
	//private static Integer COUNTER = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToMany(fetch = FetchType.LAZY)  //@OneToMany
	private Set<Work> works;

    private WRelationshipType wRelationshipType;
	//Set<User> users = new Set<User>(); // Create an ArrayList object
	
	public WRelationship(Set<Work> works, WRelationshipType wRelationshipType) {
		super();
		//this.id = COUNTER;
		//COUNTER++;
		this.works = works;
		this.wRelationshipType = wRelationshipType;
	}
	
	public WRelationship() {
		
	}
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Work> getWorks() {
		return works;
	}

	public void setWorks(Set<Work> works) {
		this.works = works;
	}


	public WRelationshipType getwRelationshipType() {
		return wRelationshipType;
	}

	public void setwRelationshipType(WRelationshipType wRelationshipType) {
		this.wRelationshipType = wRelationshipType;
	}
	
	
	
	
}
