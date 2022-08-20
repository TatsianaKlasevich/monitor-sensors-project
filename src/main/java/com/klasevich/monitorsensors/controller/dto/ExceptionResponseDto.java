package com.klasevich.monitorsensors.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Builder
public class ExceptionResponseDto {

    private String exceptionName;

    private HttpStatus httpStatus;

    private String message;
}
