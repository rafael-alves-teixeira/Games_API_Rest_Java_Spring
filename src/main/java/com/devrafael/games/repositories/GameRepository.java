package com.devrafael.games.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devrafael.games.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
