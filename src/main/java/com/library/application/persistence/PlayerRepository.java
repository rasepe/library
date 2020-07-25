package com.library.application.persistence;

import org.springframework.data.repository.CrudRepository;

import com.library.application.domain.Player;



public interface PlayerRepository extends CrudRepository<Player, Long> {

}

