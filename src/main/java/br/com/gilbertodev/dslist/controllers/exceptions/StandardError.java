package br.com.gilbertodev.dslist.controllers.exceptions;

import java.time.Instant;

/**
 * Represents a standardized error response structure for the DSList API.
 * This class provides a consistent format for communicating error details to clients,
 * including a timestamp, HTTP status code, a general error description,
 * a specific error message, and the request path that caused the error.
 *
 * <p>It is designed to be used by global exception handlers to encapsulate
 * various types of API errors into a uniform and understandable payload.</p>
 *
 * @author Gilberto Dev
 * @since 1.0.0
 */
public class StandardError {

    /**
     * The timestamp when the error occurred, represented in UTC.
     */
    private Instant timestamp;

    /**
     * The HTTP status code associated with the error (e.g., 400, 500).
     */
    private int status;

    /**
     * A general description or type of the error (e.g., "Bad Request", "Internal Server Error").
     */
    private String error;

    /**
     * A specific, more detailed message about the error, often directly from the exception.
     */
    private String message;

    /**
     * The URI path of the request that triggered the error.
     */
    private String path;

    /**
     * Default constructor for {@code StandardError}.
     * Initializes the timestamp to the current UTC instant.
     */
    public StandardError() {
        this.timestamp = Instant.now();
    }

    /**
     * Constructs a new {@code StandardError} with all details.
     *
     * @param timestamp The exact time the error occurred.
     * @param status The HTTP status code (e.g., 400 for Bad Request).
     * @param error A concise description of the error type.
     * @param message A more detailed message explaining the error.
     * @param path The request URI path where the error happened.
     */
    public StandardError(Instant timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    /**
     * Retrieves the timestamp of when the error occurred.
     * @return The {@link Instant} representing the error timestamp.
     */
    public Instant getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp for when the error occurred.
     * @param timestamp The {@link Instant} to set.
     */
    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Retrieves the HTTP status code of the error.
     * @return The integer HTTP status code.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the HTTP status code for the error.
     * @param status The integer HTTP status code to set.
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Retrieves the general error description.
     * @return The error description string.
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the general error description.
     * @param error The error description string to set.
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Retrieves the detailed error message.
     * @return The error message string.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the detailed error message.
     * @param message The error message string to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Retrieves the request path where the error occurred.
     * @return The request path string.
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the request path where the error occurred.
     * @param path The request path string to set.
     */
    public void setPath(String path) {
        this.path = path;
    }
}