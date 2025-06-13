package br.com.gilbertodev.dslist.services;

import br.com.gilbertodev.dslist.dto.GameListDTO;
import br.com.gilbertodev.dslist.entities.GameList;
import br.com.gilbertodev.dslist.exceptions.InvalidMoveException;
import br.com.gilbertodev.dslist.projections.GameMinProjection;
import br.com.gilbertodev.dslist.repositories.GameListRepository;
import br.com.gilbertodev.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class responsible for handling business logic related to {@link GameList} entities.
 *
 * @author Gilberto Dev
 * @since 1.0.0
 */
@Service
public class GameListService {

    private final GameListRepository gameListRepository;
    private final GameRepository gameRepository;

    /**
     * Constructs a GameListService with the specified repositories.
     *
     * @param gameListRepository the repository for managing game lists
     * @param gameRepository     the repository for managing games
     */
    public GameListService(GameListRepository gameListRepository, GameRepository gameRepository) {
        this.gameListRepository = gameListRepository;
        this.gameRepository = gameRepository;
    }

    /**
     * Retrieves all game lists from the database.
     *
     * @return a list of {@link GameListDTO} containing all game lists
     */
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    /**
     * Changes the position of a game within a game list.
     * <p>
     * This method updates the in-memory list of game projections by moving
     * a game from its source index to a new destination index. After reordering,
     * the method updates the database with the new positions of the affected items.
     * </p>
     *
     * @param listId           the ID of the game list
     * @param sourceIndex      the original index of the game
     * @param destinationIndex the new index to move the game to
     */
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        int size = list.size();

        if (sourceIndex < 0 || sourceIndex >= size || destinationIndex < 0 || destinationIndex >= size) {
            throw new InvalidMoveException("Source or destination index is out of bounds");
        }

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
