package phoenixit.education.exceptions;

/**
 * Exception - data not found.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}