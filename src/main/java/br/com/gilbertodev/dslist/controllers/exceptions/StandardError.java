package br.com.gilbertodev.dslist.controllers.exceptions;

import java.time.Instant;

/**
 * Standard structure for error responses returned by the API.
 * Encapsulates timestamp, HTTP status, error description, message, and path.
 * <p>
 * Can be used across different exception handlers.
 * </p>
 *
 * @author Gilberto
 */
public class StandardError {

    private Instant timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public StandardError() {
        this.timestamp = Instant.now();
    }

    public StandardError(Instant timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
