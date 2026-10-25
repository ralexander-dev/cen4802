package exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// Custom exception for when a project is not found by ID
public class ProjectNotFoundException extends RuntimeException {
  private static final Logger logger = LoggerFactory.getLogger(ProjectNotFoundException.class);

  // Constructor that takes a message and passes it to the superclass
  public ProjectNotFoundException(String message) {
    super(message); // Call the constructor of the superclass (RuntimeException) with the message
    logger.error("Project not found: {}", message);
  }
}
