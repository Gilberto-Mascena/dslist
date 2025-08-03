package br.com.gilbertodev.dslist.controllers;

import br.com.gilbertodev.dslist.dto.GameListDTO;
import br.com.gilbertodev.dslist.dto.GameMinDTO;
import br.com.gilbertodev.dslist.dto.ReplacementDTO;
import br.com.gilbertodev.dslist.services.GameListService;
import br.com.gilbertodev.dslist.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing game lists within the DSList application.
 * This controller provides API endpoints to retrieve all available game lists,
 * fetch the games belonging to a specific list, and reorder games within a list.
 *
 * @author Gilberto Dev
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/lists")
@Tag(name = "Game Lists", description = "Endpoints for managing game lists and their games")
public class GameListController {

    private final GameListService gameListService;
    private final GameService gameService;

    /**
     * Constructs a new {@code GameListController} with the necessary services injected.
     * Spring's dependency injection will automatically provide instances of
     * {@link GameListService} and {@link GameService}.
     *
     * @param gameListService The service for managing game list operations.
     * @param gameService     The service for managing individual game operations.
     */
    private GameListController(GameListService gameListService, GameService gameService) {
        this.gameListService = gameListService;
        this.gameService = gameService;
    }

    /**
     * Retrieves a list of all available game lists.
     * Each list is represented by a {@link GameListDTO}, containing basic information
     * about the list.
     *
     * @return A {@link List} of {@link GameListDTO} objects.
     */
    @Operation(
            summary = "Find all game lists",
            description = "Retrieves a comprehensive list of all game lists available in the system.",
            tags = {"lists catalog"}
    )
    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    /**
     * Retrieves a list of games belonging to a specific game list.
     * The games are returned in a minimized format ({@link GameMinDTO}),
     * suitable for display in a list view.
     *
     * @param listId The unique identifier of the game list.
     * @return A {@link List} of {@link GameMinDTO} objects for the specified list.
     */
    @Operation(
            summary = "Find games by list ID",
            description = "Fetches all games associated with a specific game list, identified by its ID.",
            tags = {"lists by id"}
    )
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    /**
     * Moves a game from one position to another within a specific game list.
     * This operation updates the order of games in the list based on the provided
     * source and destination indices. The response typically indicates success
     * without returning content.
     *
     * @param listId The unique identifier of the game list where the move operation occurs.
     * @param body   A {@link ReplacementDTO} object containing the {@code sourceIndex}
     * (current position of the game) and {@code destinationIndex}
     * (desired new position of the game).
     */
    @Operation(
            summary = "Move a game's position within a list",
            description = "Updates the order of games in a specific list by moving a game from one index to another.",
            tags = {"Game Lists"}
    )
    @PutMapping(value = "/{listId}/replacement")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Indicates successful processing without content in the response body.
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}