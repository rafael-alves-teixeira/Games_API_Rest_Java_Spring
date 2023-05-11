package com.devrafael.games.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devrafael.games.dto.GameListDTO;
import com.devrafael.games.services.GameListService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	public GameListService gameListService;
	
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}		
	
 }
