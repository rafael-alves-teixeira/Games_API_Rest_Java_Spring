package com.devrafael.games.dto;

import org.springframework.beans.BeanUtils;

import com.devrafael.games.entities.GameList;

public class GameListDTO {
	
	private Long id;
	private String name;
	
	public GameListDTO() {		
	}

	public GameListDTO(GameList entity) {
		id = entity.getId();
		name = entity.getName();
		
//		ATENÇÃO! - Diferentemente da classe "GameDTO", NÃO usei o "BeanUtils.copyProperties(entity, this)
		//porque aqui temos poucos atributos. Aliás, por conta disso,
		//não preciso criar os "SETs", mas apenas os "GETs".
			
		
	}

	public Long getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}

		
	
	
	

}
