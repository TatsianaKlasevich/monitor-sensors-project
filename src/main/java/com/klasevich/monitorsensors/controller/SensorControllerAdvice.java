package com.klasevich.monitorsensors.controller;

import com.klasevich.monitorsensors.controller.dto.ExceptionResponseDto;
import com.klasevich.monitorsensors.exception.SensorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice
public class SensorControllerAdvice {
    private static final String DEFAULT_VALIDATION_MESSAGE_ERROR = "Request contains invalid parameters";

    @ExceptionHandler({SensorNotFoundException.class})
    public ExceptionResponseDto handleUserNoFound(Exception e) {
        return ExceptionResponseDto.builder()
                .exceptionName(e.getClass().getName())
                .httpStatus(HttpStatus.NOT_FOUND)
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ExceptionResponseDto handleNotValid(Exception e) {
        String message;
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException notValidException = (MethodArgumentNotValidException) e;
            message = Optional.of(notValidException.getBindingResult())
                    .map(BindingResult::getFieldError)
                    .map(FieldError::getDefaultMessage)
                    .orElse(DEFAULT_VALIDATION_MESSAGE_ERROR);
        } else {
            message = e.getMessage();
        }

        return ExceptionResponseDto.builder()
                .exceptionName(e.getClass().getName())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message(message)
                .build();
    }
}
