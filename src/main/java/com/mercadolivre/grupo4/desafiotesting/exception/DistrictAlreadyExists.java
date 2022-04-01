package com.mercadolivre.grupo4.desafiotesting.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class DistrictAlreadyExists extends BaseException{

    public DistrictAlreadyExists(String districtName) {
        super("O bairro " + districtName + " já está cadastrado.", HttpStatus.CONFLICT, ZonedDateTime.now());

    }
}
