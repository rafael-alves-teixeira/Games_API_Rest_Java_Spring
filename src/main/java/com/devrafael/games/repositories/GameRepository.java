package com.devrafael.games.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devrafael.games.entities.Game;
import com.devrafael.games.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long>{
	
	//Como o código abaixo não é JPQL e é um SQL PURO, foi necessário escrever esse código
	@Query(nativeQuery = true, value = """ 
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);

}
