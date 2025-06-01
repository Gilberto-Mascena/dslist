package br.com.gilbertodev.dslist.controllers;

import br.com.gilbertodev.dslist.dto.GameListDTO;
import br.com.gilbertodev.dslist.dto.GameMinDTO;
import br.com.gilbertodev.dslist.dto.ReplacementDTO;
import br.com.gilbertodev.dslist.services.GameListService;
import br.com.gilbertodev.dslist.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing game lists.
 *
 * <p>Allows retrieving all lists, fetching games from a specific list,
 * and changing the order of games within a list.</p>
 *
 * @author Gilberto Dev
 */
@RestController
@RequestMapping(value = "/lists")
@Tag(name = "Game Lists", description = "Endpoints for managing game lists")
public class GameListController {

    private final GameListService gameListService;
    private final GameService gameService;

    /**
     * Injects the required services via constructor.
     *
     * @param gameListService the game list service
     * @param gameService     the game service
     */
    private GameListController(GameListService gameListService, GameService gameService) {
        this.gameListService = gameListService;
        this.gameService = gameService;
    }

    /**
     * Retrieves all available game lists.
     *
     * @return a list of {@link GameListDTO} objects
     */
    @Operation(summary = "Find all lists", description = "Find all lists and their games", tags = {"lists catalog"})
    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    /**
     * Retrieves all games belonging to a specific list.
     *
     * @param listId the ID of the list
     * @return a list of {@link GameMinDTO} for the specified list
     */
    @Operation(summary = "Find list by id", description = "Find a list by its id and its game", tags = {"lists by id"})
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    /**
     * Moves a game from one position to another in a specific list.
     *
     * @param listId the ID of the list
     * @param body   an object containing the source and destination indices
     */
    @Operation(summary = "Move game", description = "Move a game's position in the list", tags = {"Game Lists"})
    @PostMapping(value = "/{listId}/replacement")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
