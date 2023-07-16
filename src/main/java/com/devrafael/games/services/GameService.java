package com.devrafael.games.services;

import java.util.List;
import java.util.Optional;

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
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(GameMinDTO::new).toList();
	}

	@Transactional(readOnly = true)
	public Optional<GameDTO> findById(Long id) {
		Optional<Game> game = gameRepository.findById(id);
		return game.map(GameDTO::new);
	}

	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long ListId) {
		List<GameMinProjection> result = gameRepository.searchByList(ListId);
		return result.stream().map(GameMinDTO::new).toList();

	}

}
