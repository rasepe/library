package com.library.application.persistence;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.application.domain.Game;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
	
   // Page<Game> findByPlayerId(Long playerId, Pageable pageable);
	
	//List<Game> findByPlayerId(Long playerId, Pageable pageable);
    //Game findByPlayerId(Long playerId);  //???
   
	// Optional<Game> findByIdAndPlayerId(Long id, Long shopId); <---ERROR
   // List<Picture> deleteByShopId(Long shopId);

	
}