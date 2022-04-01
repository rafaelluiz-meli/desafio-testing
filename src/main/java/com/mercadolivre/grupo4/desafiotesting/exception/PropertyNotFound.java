package com.mercadolivre.grupo4.desafiotesting.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class PropertyNotFound extends BaseException {

    public PropertyNotFound(long id) {

        super("A propriedade com id: " + id + " não foi encontrado.", HttpStatus.NOT_FOUND, ZonedDateTime.now());

    }
}
