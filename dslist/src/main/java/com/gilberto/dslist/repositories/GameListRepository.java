package com.gilberto.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gilberto.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
    
}
