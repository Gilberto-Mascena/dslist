package br.com.gilbertodev.dslist.controllers;

import br.com.gilbertodev.dslist.dto.GameDTO;
import br.com.gilbertodev.dslist.dto.GameMinDTO;
import br.com.gilbertodev.dslist.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Resource
    private GameService gameService;

    @Operation(summary = "Find a game by id", description = "Find a game by id and return the game", tags = {"game by id"})
    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        GameDTO result = gameService.findById(id);
        return result;
    }

    @Operation(summary = "Find all games", description = "Find all games and return a list of games", tags = {"all games"})
    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
