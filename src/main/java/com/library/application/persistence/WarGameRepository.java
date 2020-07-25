package com.library.application.persistence;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

//import com.library.application.domain.Movement;
import com.library.application.domain.WarGame;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface WarGameRepository extends JpaRepository<WarGame, Integer> {

	/*
	 * @Query("SELECT * FROM war_game WHERE id = ?1") WarGame
	 * findWarGameById(Integer id);
	 */
	
	/*
	 * @Override
	 * 
	 * @Transactional(timeout = 2) public List<WarGame> findAll();
	 */

}