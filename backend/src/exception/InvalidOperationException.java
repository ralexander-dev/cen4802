package exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// Custom exception for invalid operations, such as trying to update a deleted project or restore an active project
public class InvalidOperationException extends RuntimeException {
  private static final Logger logger = LoggerFactory.getLogger(InvalidOperationException.class);

  // Constructor that takes a message and passes it to the superclass
  public InvalidOperationException(String message) {
    super(message); // Call the constructor of the superclass (RuntimeException) with the message
    logger.error("Invalid operation: {}", message);
  }
}
