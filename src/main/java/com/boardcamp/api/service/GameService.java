package com.boardcamp.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.boardcamp.api.dtos.GameDTO;
import com.boardcamp.api.models.GameModel;
import com.boardcamp.api.repository.GameRepository;

@Service
public class GameService {
  final GameRepository gameRepository;

  GameService(GameRepository gameRepository){
    this.gameRepository = gameRepository;
  }

  public List<GameModel> findAll(){
    return gameRepository.findAll();
  }

  public Optional<GameModel> save(GameDTO dto){

    //TODO uma query no repository que retorna true ou false em caso de exista um game com o mesmo nome

    GameModel game = new GameModel(dto);
    return Optional.of(gameRepository.save(game));
  }
}
