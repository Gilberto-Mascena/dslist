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
 * REST controller responsible for handling game-related API requests.
 * This class provides endpoints for retrieving a list of all games
 * and fetching detailed information for a single game by its ID.
 *
 * @author Gilberto Dev
 * @since 1.0.0
 */
@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    /**
     * Constructs a new {@code GameController} with the specified {@link GameService}.
     * Spring will automatically inject the {@code GameService} dependency.
     *
     * @param gameService The service responsible for game-related business logic.
     */
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    /**
     * Retrieves detailed information about a single game by its unique identifier.
     * <p>
     * This endpoint handles validation for the provided ID and gracefully
     * responds with appropriate HTTP status codes for invalid input or
     * if the game is not found.
     * </p>
     *
     * @param id The unique identifier of the game to retrieve.
     * @return A {@link GameDTO} containing the detailed information of the found game.
     * @throws ResponseStatusException If the provided {@code id} is invalid (HTTP 400 BAD_REQUEST)
     *                                 or if no game is found with the given ID (HTTP 404 NOT_FOUND).
     */
    @Operation(
            summary = "Find a game by ID",
            description = "Retrieves detailed information for a single game based on its ID.",
            tags = {"games"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Game found and returned successfully."),
                    @ApiResponse(responseCode = "400", description = "Invalid game ID provided (e.g., null or non-positive)."),
                    @ApiResponse(responseCode = "404", description = "Game not found for the given ID.")
            }
    )
    @GetMapping("/{id}")
    public GameDTO findById(@PathVariable Long id) {
        // Input validation for the path variable
        if (id == null || id <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid game ID: " + id);
        }
        try {
            return gameService.findById(id);
        } catch (EntityNotFoundException e) {
            // Catches specific JPA exception and maps it to an HTTP 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found with ID: " + id, e);
        }
    }

    /**
     * Retrieves a simplified list of all games available in the system.
     * <p>
     * Each game in the list is represented by {@link GameMinDTO},
     * containing essential information like ID, title, and image URL.
     * </p>
     *
     * @return A {@link List} of {@link GameMinDTO} representing all games.
     */
    @Operation(
            summary = "Find all games",
            description = "Retrieves a list of all games with minimized details.",
            tags = {"games"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of games.")
            }
    )
    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }
}