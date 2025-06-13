package br.com.gilbertodev.dslist.exceptions;

/**
 * Exception thrown when a game with the specified ID is not found.
 *
 * @author Gilberto Dev
 * @since 1.0.0
 */
public class GameNotFoundException extends RuntimeException {

    public GameNotFoundException(Long id) {
        super("Game not found with id: " + id);
    }
}

