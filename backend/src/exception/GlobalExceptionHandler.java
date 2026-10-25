package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
  GlobalExceptionHandler.java
  This class handles a variety of exceptions thrown by the REST API and returns appropriate HTTP responses by
  grouping all exception handling logic in one place. 
*/

@RestControllerAdvice
public class GlobalExceptionHandler {
  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  // Handle ProjectNotFoundException - 404 Not Found
  @ExceptionHandler(ProjectNotFoundException.class)
  public ResponseEntity<Map<String, String>> handleProjectNotFound(ProjectNotFoundException e) {

    logger.error("Project not found: {}", e.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage())); // Return NOT_FOUND with error message
  }

  // Handle ValidationException - 400 Bad Request
  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<Map<String, String>> handleValidation(ValidationException e) {
    logger.error("Validation error: {}", e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage())); // Return BAD_REQUEST with error message
  }

  // Handle InvalidOperationException - 409 Conflict
  @ExceptionHandler(InvalidOperationException.class)
  public ResponseEntity<Map<String, String>> handleInvalidOperation(InvalidOperationException e) {
    logger.error("Invalid operation: {}", e.getMessage());
    return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", e.getMessage())); // Return CONFLICT with error message
  }

  // Handle IOException - 400 Bad Request
  @ExceptionHandler(java.io.IOException.class)
  public ResponseEntity<Map<String, String>> handleIOException(java.io.IOException e) {
    logger.error("IO error: {}", e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage())); // Return BAD_REQUEST with error message
  }
}
