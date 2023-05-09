package com.gilberto.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gilberto.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
    
}
