package ru.fotoochkarik.checkcollector.controller;


import javax.validation.ValidationException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.fotoochkarik.checkcollector.exception.BusinessException;
import ru.fotoochkarik.checkcollector.exception.SystemException;
import ru.fotoochkarik.generated.v1.dto.ExceptionMessageResponse;

@RestControllerAdvice
class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  @Value("${spring.application.name}")
  private String applicationName;

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ExceptionMessageResponse> handleBusinessException(BusinessException exception) {
    var httpStatus = HttpStatus.BAD_REQUEST;
    var response = generateExceptionMessageResponse(exception, httpStatus, exception.getErrorCode());
    return ResponseEntity.status(httpStatus).body(response);
  }

  @ExceptionHandler(SystemException.class)
  public ResponseEntity<ExceptionMessageResponse> handleAnotherException(SystemException exception) {
    var httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    var baseResponse = generateExceptionMessageResponse(exception, httpStatus, exception.getErrorCode());
    return new ResponseEntity<>(baseResponse, httpStatus);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleException(Exception exception) {
    var httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    var baseResponse = generateExceptionMessageResponse(exception, httpStatus, "fatal");
    return new ResponseEntity<>(baseResponse, httpStatus);
  }

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<Object> handleValidationException(ValidationException exception) {
    var httpStatus = HttpStatus.BAD_REQUEST;
    var baseResponse = generateExceptionMessageResponse(exception, httpStatus, httpStatus.name());
    return new ResponseEntity<>(baseResponse, httpStatus);
  }

  private ExceptionMessageResponse generateExceptionMessageResponse(Exception exception, HttpStatus httpStatus,
      String errorCode) {
    return new ExceptionMessageResponse()
        .source(applicationName)
        .status(httpStatus.value())
        .code(errorCode)
        .errorMessage(exception.getMessage())
        .success(false)
        .stackTrace(ExceptionUtils.getStackTrace(exception));
  }

}