package com.devrafael.games.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devrafael.games.dto.GameDTO;
import com.devrafael.games.dto.GameMinDTO;
import com.devrafael.games.entities.Game;
import com.devrafael.games.projections.GameMinProjection;
import com.devrafael.games.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result =  gameRepository.findById(id).get();
		return new GameDTO(result);		
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();		
//		return result.stream().map(x -> new GameMinDTO(x)).toList();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long ListId){
		List<GameMinProjection> result = gameRepository.searchByList(ListId);		
		return result.stream().map(x -> new GameMinDTO(x)).toList();
		
	}

}
