package com.lind.springsecurityjwt.exception;

import java.net.BindException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Exrickx
 */
@RestControllerAdvice
public class RestExceptionHandler {

  /**
   * INTERNAL_SERVER_ERROR.
   *
   * @param e
   * @return
   */
  @ExceptionHandler( {RuntimeException.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity handleException(RuntimeException e) {
    String errorMsg = "handleException：";
    if (e != null) {
      errorMsg = errorMsg + e.getMessage();
      System.out.println(errorMsg);
    }
    return ResponseEntity.ok(errorMsg);
  }

  /**
   * AccessDeniedException.
   *
   * @param e
   * @return
   */
  @ExceptionHandler( {AccessDeniedException.class})
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public ResponseEntity errHandleException(AccessDeniedException e) {
    String errorMsg = "accessDeniedException：";
    if (e != null) {
      errorMsg = errorMsg + e.getMessage();
      System.out.println(errorMsg);
    }
    return ResponseEntity.ok(errorMsg);
  }

  /**
   * validation Exception.
   *
   * @param exception
   * @return R
   */
  @ExceptionHandler( {MethodArgumentNotValidException.class, BindException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity handleBodyValidException(MethodArgumentNotValidException exception) {
    List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
    return ResponseEntity.ok(fieldErrors.get(0).getDefaultMessage());
  }

  @ExceptionHandler(Throwable.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String exception(final Throwable throwable, final Model model) {
    String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
    model.addAttribute("errorMessage", errorMessage);
    return "error";
  }

}
