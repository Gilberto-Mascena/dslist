package br.com.gilbertodev.dslist.exceptions;

/**
 * Exception thrown when a move operation is invalid.
 *
 * @author Gilberto Dev
 * @since 1.0.0
 */
public class InvalidMoveException extends RuntimeException {

    public InvalidMoveException(String message) {
        super(message);
    }
}
