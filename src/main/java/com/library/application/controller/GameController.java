package com.library.application.controller;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.application.domain.Game;
import com.library.application.domain.Player;
import com.library.application.persistence.GameRepository;
import com.library.application.persistence.PlayerRepository;
import com.library.exception.ResourceNotFoundException;



@RestController	// This means that this class is a Controller
@CrossOrigin
public class GameController {

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private PlayerRepository playerRepository;

	
	
	 @GetMapping("/players/{playerId}/games") public List<Game>
	 getAllGamesByPlayerId(@PathVariable (value = "playerId") Long playerId) { 
		 Iterable<Game> allGames = gameRepository.findAll();
		 List<Game> gamesByPlayer = new ArrayList<Game>();
		 for (Game g: allGames) {
			 if (g.getPlayer().getId() == playerId) {
				 gamesByPlayer.add(g);
			 }
		 }
		 
		 
		// return gameRepository.findByPlayerId(playerId, null);
		 return gamesByPlayer;
	  //pageable 
	  }


	@PostMapping("/players/{playerId}/games")
	public Game createGame(@PathVariable (value = "playerId") Long playerId, Game game)  { //@RequestBody Game game

		return playerRepository.findById(playerId).map(player -> {
			game.setPlayer(player);

			int dice1 = (@NotNull int) Math.floor(Math.random()*6+1);
			int dice2 = (@NotNull int) Math.floor(Math.random()*6+1);
			game.setDice1(dice1);
			game.setDice2(dice2);

			if (game.getDice1() + game.getDice2() == 7) {
				game.setHasWon(true); 
			}
			LocalDateTime time = LocalDateTime.now();
            
		      
			game.setCreatedAt(time.toString());
			



			double points = 0;
			double successRate;
			//List<Game> gamesByPlayer = new ArrayList<Game>();
			
			 Iterable<Game> allGames = gameRepository.findAll();
			 List<Game> gamesByPlayer = new ArrayList<Game>();
			 for (Game g: allGames) {
				 if (g.getPlayer().getId() == playerId) {
					 gamesByPlayer.add(g);
				 }
			 }
			 
			//gamesByPlayer = gameRepository.findByPlayerId(player.getId(), null); 

			//suma els jocs anteriors
			for (int i=0; i<gamesByPlayer.size(); i++) {
				if(gamesByPlayer.get(i).isHasWon()) {
					points += 100;
				}
			}

			//i falta el joc actual

			if (game.isHasWon()) {
				points += 100;
			}

			successRate = Math.round((points / (gamesByPlayer.size()+1)) * 100) / 100d;

			// 	game.getPlayer().setSuccessRate(successRate);
			player.setSuccessRate(successRate);

			// if (game.getAuthor()=="") {
			//  picture.setAuthor("ANONYMOUS");
			//  };
			//  shop.setNumPictures(shop.getNumPictures()+1);
			player.setHasGames(true); 

			//return gameRepository.save(game);
			gameRepository.save(game);
			return game;
		}).orElseThrow(() -> new ResourceNotFoundException("PlayerId " + playerId + " not found"));


	}


	//	@CrossOrigin(origins = "http://localhost")
	//    @PutMapping("/shops/{shopId}/pictures/{pictureId}")
	//    public Picture updatePicture(@PathVariable (value = "shopId") Long shopId,
	//                                 @PathVariable (value = "pictureId") Long pictureId,
	//                                 @Valid @RequestBody Picture pictureRequest) {
	//        if(!shopRepository.existsById(shopId)) {
	//            throw new ResourceNotFoundException("ShopId " + shopId + " not found");
	//        }
	//
	//        return pictureRepository.findById(pictureId).map(picture -> {
	//        	picture.setAuthor(pictureRequest.getAuthor());
	//            picture.setName(pictureRequest.getName());
	//            picture.setPrice(pictureRequest.getPrice());
	//            return pictureRepository.save(picture);
	//        }).orElseThrow(() -> new ResourceNotFoundException("PictureId " + pictureId + "not found"));
	//    }



	@DeleteMapping("/players/{playerId}/games")
	public void deleteAllGamesByPlayerId(@PathVariable (value = "playerId") Long playerId) {

		
		 Iterable<Game> allGames = gameRepository.findAll();
		 List<Game> gamesByPlayer = new ArrayList<Game>();
		 for (Game g: allGames) {
			 if (g.getPlayer().getId() == playerId) {
				 gamesByPlayer.add(g);
			 }
		 }
		 
		
		gameRepository.deleteAll(gamesByPlayer);
		//POSAR RATE A NULL:
		//Player player = playerRepository.getOne(playerId);
		Player player = null;
		
		
		for (Player p : playerRepository.findAll()) {
			if (p.getId() == playerId) {
				player = p;
			}
		}
		
		player.setSuccessRate(0);
		player.setHasGames(false);
		playerRepository.save(player);
	}



}