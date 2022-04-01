package com.mercadolivre.grupo4.desafiotesting.exception;

import com.mercadolivre.grupo4.desafiotesting.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
public class PropertyException extends RuntimeException{
    private final ErrorDTO errorDTO;
    private final HttpStatus httpStatus;

    public PropertyException(String message, HttpStatus httpStatus, ZonedDateTime timestamp){
        this.errorDTO = new ErrorDTO(this.getClass().getSimpleName(),message, timestamp);
        this.httpStatus = httpStatus;
    }
}
