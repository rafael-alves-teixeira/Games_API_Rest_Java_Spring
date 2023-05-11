package com.devrafael.games.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devrafael.games.dto.GameMinDTO;
import com.devrafael.games.entities.Game;
import com.devrafael.games.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();		
//		return result.stream().map(x -> new GameMinDTO(x)).toList();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}

}
