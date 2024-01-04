package ru.fotoochkarik.checkcollector.controller;

import java.util.Arrays;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.fotoochkarik.checkcollector.exception.ErrorCode;
import ru.fotoochkarik.generated.v1.dto.BaseResponse;

@RestControllerAdvice
class ApiExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(IllegalArgumentException.class)
  public BaseResponse handleIllegalArgumentException(IllegalArgumentException ex) {
    return new BaseResponse()
        .code(ErrorCode.FCC_1.getValue())
        .errorMessage(ex.getMessage())
        .success(false)
        .stackTrace(Arrays.toString(ex.getStackTrace()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleAnotherException(Exception ex) {
    HttpStatus badRequest = HttpStatus.INTERNAL_SERVER_ERROR;
    var baseResponse = new BaseResponse()
        .code(ErrorCode.FCC_2.getValue())
        .errorMessage(ex.getMessage())
        .success(false)
        .stackTrace(Arrays.toString(ex.getStackTrace()));
    return new ResponseEntity<>(baseResponse, badRequest);
  }

}