package com.mercadolivre.grupo4.desafiotesting.controller;

import com.mercadolivre.grupo4.desafiotesting.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/property")
@AllArgsConstructor
public class PropertyController {
    private final PropertyService propertyService;

    @GetMapping
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping("/getTotalArea/{propertyId}")
    public ResponseEntity<Double> getTotalArea(@PathVariable Long propertyId) {
        Double totalArea = propertyService.totalArea(propertyId);
        return ResponseEntity.ok().body(totalArea);
    }

}
