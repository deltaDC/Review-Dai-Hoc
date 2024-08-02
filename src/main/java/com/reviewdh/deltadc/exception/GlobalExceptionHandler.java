package com.reviewdh.deltadc.exception;

import com.reviewdh.deltadc.response.BaseExceptionResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static String getExceptionMessage(Exception e) {
        log.error(e.getLocalizedMessage());
        String message;

        if (e instanceof ConstraintViolationException) {
            message = ((ConstraintViolationException) e).getConstraintViolations().stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(", "));
        } else if (e instanceof MethodArgumentNotValidException) {
            message = ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", "));
        } else {
            message = "Validation error";
        }
        return message;
    }

    @ExceptionHandler({
            ConstraintViolationException.class, 
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<Object> handleCustomGlobalException(Exception e) {
        log.error(e.getLocalizedMessage());

        BaseExceptionResponse baseExceptionResponse = new BaseExceptionResponse(
                HttpStatus.BAD_REQUEST,
                getExceptionMessage(e)
        );

        return ResponseEntity.status(400)
                .body(baseExceptionResponse);
    }

    //TODO : Add more exception handler
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleException(Exception e) {
//        log.debug(e.getLocalizedMessage(), e);
//
//        BaseExceptionResponse baseExceptionResponse = new BaseExceptionResponse(
//                HttpStatus.INTERNAL_SERVER_ERROR,
//                "An unexpected error occurred. Please try again later."
//        );
//
//        return ResponseEntity.status(500)
//                .body(baseExceptionResponse);
//    }
}
