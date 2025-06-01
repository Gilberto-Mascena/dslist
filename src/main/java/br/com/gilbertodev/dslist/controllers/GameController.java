package br.com.gilbertodev.dslist.controllers;

import br.com.gilbertodev.dslist.dto.GameDTO;
import br.com.gilbertodev.dslist.dto.GameMinDTO;
import br.com.gilbertodev.dslist.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * REST controller responsible for managing game-related endpoints.
 *
 * <p>Provides endpoints to fetch all games or a single game by ID.</p>
 *
 * @author Gilberto Dev
 */
@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Operation(
            summary = "Find a game by id",
            description = "Find a game by id and return the game",
            tags = {"games"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Game found"),
                    @ApiResponse(responseCode = "404", description = "Game not found")
            }
    )
    @GetMapping("/{id}")
    public GameDTO findById(@PathVariable Long id) {
        if (id == null || id <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid game id: " + id);
        }
        try {
            return gameService.findById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found with id: " + id, e);
        }
    }

    @Operation(
            summary = "Find all games",
            description = "Find all games and return a list of games",
            tags = {"games"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of games")
            }
    )
    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }
}
