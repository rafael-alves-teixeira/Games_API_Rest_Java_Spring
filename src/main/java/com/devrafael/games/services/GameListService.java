package com.devrafael.games.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devrafael.games.dto.GameListDTO;
import com.devrafael.games.entities.GameList;
import com.devrafael.games.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
		
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();		
//		return result.stream().map(x -> new GameMinDTO(x)).toList();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}

}
