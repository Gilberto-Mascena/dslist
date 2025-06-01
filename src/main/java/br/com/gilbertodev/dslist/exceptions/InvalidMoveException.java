package br.com.gilbertodev.dslist.exceptions;

/**
 * Exception thrown when a move operation is invalid.
 *
 * @author Gilberto Dev
 */
public class InvalidMoveException extends RuntimeException {

    public InvalidMoveException(String message) {
        super(message);
    }
}
