package br.com.gilbertodev.dslist.services;

import br.com.gilbertodev.dslist.dto.GameDTO;
import br.com.gilbertodev.dslist.dto.GameMinDTO;
import br.com.gilbertodev.dslist.entities.Game;
import br.com.gilbertodev.dslist.exceptions.GameNotFoundException;
import br.com.gilbertodev.dslist.projections.GameMinProjection;
import br.com.gilbertodev.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class responsible for managing operations related to {@link Game} entities.
 *
 * @author Gilberto Dev
 */
@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    /**
     * Retrieves a game by its ID.
     *
     * @param id the ID of the game
     * @return a {@link GameDTO} containing the full game data
     */
    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));
        return new GameDTO(result);
    }

    /**
     * Retrieves all games from the database.
     *
     * @return a list of {@link GameMinDTO} with summarized game information
     */
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    /**
     * Retrieves all games that belong to a specific game list.
     *
     * @param listId the ID of the game list
     * @return a list of {@link GameMinDTO} sorted by their position in the list
     */
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(GameMinDTO::new).toList();
    }
}
