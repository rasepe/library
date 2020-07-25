package com.library.application.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.time.Year;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // This tells Hibernate to make a table out of this class
public class Game {  //extends AuditModel
	// @Autowired
	 //   private GameRepository gameRepository;
	
	//private static long COUNTER = 1;
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    
    @NotNull
    private int dice1;
    
    @NotNull
    private int dice2;
    
    private boolean hasWon = false;

    //private Timestamp createdAt;

   
    private String createdAt;
    

 //   @ManyToOne(fetch = FetchType.LAZY, optional = false)
 //   @JoinColumn(name = "player_id", nullable = false)
 //   @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "player_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    private Player player;
  //  private Long playerId;

    public Game(Player player)  {
    	//this.id = COUNTER;
    			//COUNTER++;
    	

    	this.player = player;
    	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    		Date date = new Date();
    	this.createdAt = dateFormat.format(date); // new Timestamp(System.currentTimeMillis());
    	
    	
    	
    	
    	
   // 	this.createdAt = LocalDateTime.now();
//    	this.dice1 = (@NotNull int) Math.floor(Math.random()*6+1);
//    	this.dice2 = (@NotNull int) Math.floor(Math.random()*6+1);
//    	
//    	if (this.dice1 + this.dice2 == 7) {
//    		this.hasWon = true;
//    	}
//    	double points = 0;
//    	double succesRate;
//    	List<Game> gamesByPlayer = new ArrayList<Game>();
//    	gamesByPlayer = gameRepository.findByPlayerId(player.getId(), null).getContent(); 
//    	for (int i=0; i<gamesByPlayer.size(); i++) {
//    		if(gamesByPlayer.get(i).isHasWon()) {
//    			points += 100;
//    		}
//    	}
//    	succesRate = points / gamesByPlayer.size();
//    	player.setSuccessRate(succesRate);
    }

	
	public Game() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getDice1() {
		return dice1;
	}


	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}


	public int getDice2() {
		return dice2;
	}


	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}


	public boolean isHasWon() {
		return hasWon;
	}


	public void setHasWon(boolean hasWon) {
		this.hasWon = hasWon;
	}


	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}
	



//	public Timestamp getCreatedAt() {
//		return createdAt;
//	}
//
//
//	public void setCreatedAt(Timestamp createdAt) {
//		this.createdAt = createdAt;
//	}
	
	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


//	public void setPlayerId(long playerId) {
//		this.playerId = playerId;
//		
//	}






    

    
}