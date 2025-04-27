package ru.fotoochkarik.checkcollector.controller;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class ControllerResponseValidator {

  private final Validator validator;

  @AfterReturning(pointcut = "execution(* ru.fotoochkarik.checkcollector.controller.*.*(..))", returning = "result")
  public void validateResponse(JoinPoint joinPoint, Object result) {
    validateResponse(result);
  }

  private void validateResponse(Object object) {
    if (object instanceof ResponseEntity<?> response) {
      if (response.hasBody()) {
        Set<ConstraintViolation<Object>> validationResults = validator.validate(response.getBody());
        if (isNotEmpty(validationResults)) {
          StringBuilder sb = new StringBuilder();
          validationResults.forEach(error ->
              sb.append(error.getPropertyPath()).append(" - ").append(error.getMessage()).append("\n")
          );
          String msg = sb.toString();
          log.error(msg);
          throw new ValidationException(msg);
        }
      }
    }
  }

}
