package br.com.gilbertodev.dslist.controllers.exceptions;

import br.com.gilbertodev.dslist.exceptions.InvalidMoveException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;

/**
 * Global exception handler to manage and format API error responses.
 * Handles custom and generic exceptions.
 * <p>
 * Returns a consistent error structure to the client.
 * </p>
 *
 * @author Gil
 * @see StandardError
 * @see InvalidMoveException
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles business logic violations (invalid moves).
     */
    @ExceptionHandler(InvalidMoveException.class)
    public ResponseEntity<StandardError> handleInvalidMoveException(
            InvalidMoveException ex, WebRequest request) {

        StandardError error = new StandardError(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Invalid move operation",
                ex.getMessage(),
                extractPath(request)
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request, HttpServletRequest servletRequest) {
        String acceptHeader = servletRequest.getHeader("Accept");

        if (acceptHeader != null && !acceptHeader.contains("application/json")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        StandardError error = new StandardError(
                Instant.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    private String extractPath(WebRequest request) {
        // Removes "uri=" prefix if present
        String description = request.getDescription(false);
        return description.replace("uri=", "");
    }
}
