package com.library.application.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Player { // extends AuditModel


	/**
	 * 
	 */
	//private static long COUNTER = 1L;


	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

   // @NotNull
   // @Size(max = 100)
    
    @Column(unique = true)
    private String name;
    
    private double successRate;

	//private LocalDateTime createdAt;

    //private Timestamp createdAt;
    
  //  private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 //	private Date date = new Date();
     private String createdAt;
    
	boolean hasGames = false;
    
	public Player(String name) {
		//this.id = COUNTER;
		//COUNTER++;
		this.name = name;
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 		Date date = new Date();
		this.createdAt = dateFormat.format(date); 
		//this.createdAt = new Timestamp(System.currentTimeMillis());
	}
	
	public Player() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSuccessRate() {
		return successRate;
	}

	public void setSuccessRate(double successRate) {
		this.successRate = successRate;
	}

//	public LocalDateTime getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(LocalDateTime createdAt) {
//		this.createdAt = createdAt;
//	}
	
//	public Date getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}

	public boolean isHasGames() {
		return hasGames;
	}

	public void setHasGames(boolean hasGames) {
		this.hasGames = hasGames;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}



	/*
	 * public Optional<Player> orElseThrow(Object object) { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * public Player map(Object object) { // TODO Auto-generated method stub return
	 * null; }
	 */







    
  
}