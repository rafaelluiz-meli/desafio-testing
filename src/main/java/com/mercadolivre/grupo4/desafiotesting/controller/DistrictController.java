package com.mercadolivre.grupo4.desafiotesting.controller;

import com.mercadolivre.grupo4.desafiotesting.model.District;
import com.mercadolivre.grupo4.desafiotesting.service.DistrictService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/district")
@AllArgsConstructor
public class DistrictController {

    final DistrictService districtService;

    @PostMapping
    public ResponseEntity<District> createDistrict(@Valid @RequestBody District district){
        District district1 = districtService.createDistrict(district);
        return ResponseEntity.status(HttpStatus.CREATED).body(district);
    }
}
