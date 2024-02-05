package com.boardcamp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.boardcamp.api.models.GameModel;

@Repository
public interface GameRepository extends JpaRepository<GameModel, Long> {

  @Query("SELECT CASE WHEN COUNT(g) > 0 THEN true ELSE false END FROM GameModel g WHERE g.name = :gameName")
  boolean existsByName(@Param("gameName") String gameName);
}
