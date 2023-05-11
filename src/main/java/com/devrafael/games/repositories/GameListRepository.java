package com.devrafael.games.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devrafael.games.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
