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
 * Global exception handler for the DSList API.
 * This class intercepts and processes various types of exceptions thrown during
 * request processing, converting them into a consistent {@link StandardError}
 * format for clients.
 *
 * <p>It provides centralized error handling, ensuring that API consumers
 * receive meaningful and structured error responses.</p>
 *
 * @author Gilberto Dev
 * @see StandardError
 * @see InvalidMoveException
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles {@link InvalidMoveException} specifically.
     * This exception is typically thrown when a game move operation (e.g., reordering)
     * violates business rules, such as invalid source or destination indices.
     *
     * <p>It returns an HTTP 400 Bad Request status with a detailed error message.</p>
     *
     * @param ex      The {@link InvalidMoveException} that was thrown.
     * @param request The current {@link WebRequest}, providing access to request details.
     * @return A {@link ResponseEntity} containing a {@link StandardError} object
     * and an HTTP status of {@code 400 Bad Request}.
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

    /**
     * A general exception handler for all unhandled exceptions.
     * This method acts as a fallback for any exception not caught by more specific handlers.
     *
     * <p>It checks the `Accept` header to ensure JSON is expected before returning
     * a {@link StandardError} response. If JSON is not expected, it returns an
     * empty response with HTTP 500 status.</p>
     *
     * @param ex             The {@link Exception} that was thrown.
     * @param request        The current {@link WebRequest}.
     * @param servletRequest The current {@link HttpServletRequest} to inspect headers.
     * @return A {@link ResponseEntity} containing either a {@link StandardError} (if JSON is accepted)
     * or an empty body (otherwise), with an HTTP status of {@code 500 Internal Server Error}.
     */
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

    /**
     * Extracts and cleans the request path from a {@link WebRequest} description.
     * This helper method ensures that the path in the error response is clean
     * and does not contain the "uri=" prefix sometimes added by {@link WebRequest}.
     *
     * @param request The {@link WebRequest} object.
     * @return The cleaned request URI path.
     */
    private String extractPath(WebRequest request) {
        // Removes "uri=" prefix if present
        String description = request.getDescription(false);
        return description.replace("uri=", "");
    }
}
