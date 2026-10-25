package exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// Custom exception for validation errors, such as missing required fields or invalid input formats
public class ValidationException extends RuntimeException {
  private static final Logger logger = LoggerFactory.getLogger(ValidationException.class);

  // Constructor that takes a message and passes it to the superclass
  public ValidationException(String message) {
    super(message); // Call the constructor of the superclass (RuntimeException) with the message
    logger.error("Validation error: {}", message);
  }
}
