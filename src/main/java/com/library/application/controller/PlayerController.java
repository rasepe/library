package com.library.application.controller;

import java.awt.print.Pageable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.application.domain.Game;
import com.library.application.domain.Player;
import com.library.application.persistence.GameRepository;
import com.library.application.persistence.PlayerRepository;
import com.library.exception.ResourceNotFoundException;



@RestController	// This means that this class is a Controller
@CrossOrigin
public class PlayerController {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private GameRepository gameRepository;


	@GetMapping("/players")
	public List<Player> getAllPlayers() { //Page<Player> getAllPlayers(Pageable pageable)
		
		
		List<Player> allPlayers = new ArrayList<Player>();
		
		for (Player p: playerRepository.findAll()) {
			allPlayers.add(p);
		}
		
		return allPlayers;
	}


	@GetMapping("/players/ranking")
	public double getAllPlayersRanking() {
		// return playerRepository.findAll(pageable);

		// playerRepository.findAll(pageable).getNumberOfElements();
		// playerRepository.findAll(pageable).getContent();

		double addition = 0;
		
List<Game> allGames = new ArrayList<Game>();
		
		for (Game g: gameRepository.findAll()) {
			allGames.add(g);
		}

		for (int i=0; i<allGames.size(); i++) {
			if (allGames.get(i).isHasWon()) {
				addition +=100;
			}

		}


		double average = Math.round(addition*100 / allGames.size()) / 100d; // ;

		return average;

	}
	@GetMapping("/players/{playerId}/ranking")
	public double getOnePlayerRanking(@PathVariable Long playerId) {
		
		
		Player player = playerRepository.findById(playerId)
				.orElseThrow(() -> new ResourceNotFoundException("PlayerId " + playerId + " not found"));
	

		double average = player.getSuccessRate();

		return average;

	}

	

	 

	@GetMapping("/players/ranking/loser")
	public ArrayList<Player> getLoserRanking() {
		// return playerRepository.findAll(pageable);
		
List<Player> allPlayers = new ArrayList<Player>();
		
		for (Player p: playerRepository.findAll()) {
			allPlayers.add(p);
		}

		double playeraverage = 0;
		double minimum = 1000;
		// long loserId;
		Player loser = null;
		ArrayList<Player> losers = new ArrayList<Player>(); 
		for (int i=0; i<allPlayers.size(); i++) {
			//        	if (gameRepository.findAll(pageable).getContent().get(i).isHasWon()) {
			//        		addition +=100;
			//        	}

			if (allPlayers.get(i).isHasGames()) {
				playeraverage = allPlayers.get(i).getSuccessRate();
				if (minimum > playeraverage) {
					minimum=playeraverage;
					//loserId = playerRepository.findAll(pageable).getContent().get(i).getId();
					loser = allPlayers.get(i);
					if(losers.size() > 0 ) {
						losers.remove( losers.size() - 1 );
					}           
					losers.add(loser);
				} else if (minimum==playeraverage) {
					minimum=playeraverage;
					//loserId = playerRepository.findAll(pageable).getContent().get(i).getId();
					loser = allPlayers.get(i);
					losers.add(loser);
				}

			}


		}


		// double average = addition / gameRepository.findAll(pageable).getNumberOfElements();

		return losers;

	}



	@GetMapping("/players/ranking/winner")
	public ArrayList<Player> getWinnerRanking() {
		// return playerRepository.findAll(pageable);
List<Player> allPlayers = new ArrayList<Player>();
		
		for (Player p: playerRepository.findAll()) {
			allPlayers.add(p);
		}
	

		double playeraverage = 0;
		double maximum = 0;
		// long loserId;
		Player winner = null;
		ArrayList<Player> winners = new ArrayList<Player>(); 

		for (int i=0; i<allPlayers.size(); i++) {
			//        	if (gameRepository.findAll(pageable).getContent().get(i).isHasWon()) {
			//        		addition +=100;
			//        	}

			if (allPlayers.get(i).isHasGames()) {
				playeraverage = allPlayers.get(i).getSuccessRate();
				if (maximum < playeraverage) {
					maximum=playeraverage;
					//loserId = playerRepository.findAll(pageable).getContent().get(i).getId();
					winner = allPlayers.get(i);
					if(winners.size() > 0 ) {
						winners.remove( winners.size() - 1 );
					}           
					winners.add(winner);
				} else if (maximum == playeraverage) {
					maximum=playeraverage;
					//loserId = playerRepository.findAll(pageable).getContent().get(i).getId();
					winner = allPlayers.get(i);
					winners.add(winner);
				}

			}


		}


		// double average = addition / gameRepository.findAll(pageable).getNumberOfElements();

		return winners;

	}

	//	// Single item
	//	@GetMapping("/shops/{shopId}")
	//	Shop one(@PathVariable Long shopId) {
	//		
	//		return shopRepository.findById(shopId)
	//			.orElseThrow(() -> new ResourceNotFoundException("ShopId " + shopId + " not found"));
	//	}
	//	

	@PostMapping("/players")
	public Player createPlayer(@RequestBody Player player) {
		
List<Player> allPlayers = new ArrayList<Player>();
		
		for (Player p: playerRepository.findAll()) {
			allPlayers.add(p);
		}

		// player.setName("ANONYMOUS");
		//}; }
		

		LocalDateTime time = LocalDateTime.now();
             
      
		player.setCreatedAt(time.toString());
		if (player.getName()=="") {
			player.setName(null);
		};
		// return playerRepository.save(player);
		playerRepository.save(player);
		//return allPlayers.get(allPlayers.size()-1);
return player;
	}

	//    @CrossOrigin(origins = "http://localhost")
	//    @PutMapping("/players/{playerId}")
	//   public Player updatePlayer(@PathVariable Long playerId, Player playerRequest) {  //@Valid @RequestBody
	//        return playerRepository.findById(playerId).map(player -> {
	//           player.setName(playerRequest.getName());
	//            return playerRepository.save(player);
	//        }).orElseThrow(() -> new ResourceNotFoundException("PlayerId " + playerId + " not found"));
	//  }


	
	@PutMapping("/players/{id}") Player replacePlayer(@RequestBody Player
			newPlayer, @PathVariable Long id) {

		return playerRepository.findById(id) .map(player -> {
			player.setName(newPlayer.getName()); return playerRepository.save(player); })
				.orElseGet(() -> { newPlayer.setId(id); return
						playerRepository.save(newPlayer); }); }




	//
	//    @DeleteMapping("/shops/{shopId}")
	//    public ResponseEntity<?> deleteShop(@PathVariable Long shopId) {
	//        return shopRepository.findById(shopId).map(shop -> {
	//            shopRepository.delete(shop);
	//            return ResponseEntity.ok().build();
	//        }).orElseThrow(() -> new ResourceNotFoundException("ShopId " + shopId + " not found"));
	//    }

}
