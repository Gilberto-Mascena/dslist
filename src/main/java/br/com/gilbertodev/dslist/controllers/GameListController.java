package br.com.gilbertodev.dslist.controllers;

import br.com.gilbertodev.dslist.dto.GameListDTO;
import br.com.gilbertodev.dslist.dto.GameMinDTO;
import br.com.gilbertodev.dslist.dto.ReplacementDTO;
import br.com.gilbertodev.dslist.services.GameListService;
import br.com.gilbertodev.dslist.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Resource
    private GameListService gameListService;

    @Resource
    private GameService gameService;

    @Operation(summary = "Find all lists", description = "Find all lists and their games", tags = {"lists catalog"})
    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @Operation(summary = "Find list by id", description = "Find a list by its id and its game", tags = {"lists by id"})
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @Operation(summary = "Move game", description = "Move a game's position in the list", tags = {"move game"})
    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
