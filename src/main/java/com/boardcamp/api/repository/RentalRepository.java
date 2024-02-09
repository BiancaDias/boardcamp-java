package com.boardcamp.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boardcamp.api.models.RentalModel;

@Repository
public interface RentalRepository extends JpaRepository<RentalModel, Long> {
  @Query(value = "SELECT * FROM rentals WHERE game = :gameId", nativeQuery = true)
    List<RentalModel> findAllByGameId(Long gameId);
}
