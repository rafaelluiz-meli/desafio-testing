package com.mercadolivre.grupo4.desafiotesting.controller;

import com.mercadolivre.grupo4.desafiotesting.dto.ErrorDTO;
import com.mercadolivre.grupo4.desafiotesting.exception.PropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class PropertyExceptionController {

    @ExceptionHandler(PropertyException.class)
    public ResponseEntity<Object> handleGlobalExceptions(PropertyException e){
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException e){
        ErrorDTO errorDTO = new ErrorDTO(e.getClass().getSimpleName(), e.getFieldError().getDefaultMessage(), ZonedDateTime.now());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
