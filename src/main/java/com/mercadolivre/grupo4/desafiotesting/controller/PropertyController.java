package com.mercadolivre.grupo4.desafiotesting.controller;

import com.mercadolivre.grupo4.desafiotesting.dto.PropertyDTO;
import com.mercadolivre.grupo4.desafiotesting.model.Property;
import com.mercadolivre.grupo4.desafiotesting.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;


@RestController
@RequestMapping("/property")
@AllArgsConstructor
public class PropertyController {
    private final PropertyService propertyService;

    @GetMapping
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping(path = "value/{propId}")
    public ResponseEntity<BigDecimal> getPropertyValue(@PathVariable Long propId){
        BigDecimal result = propertyService.calcValue(propId);
        return ResponseEntity.ok().body(result);
    }
}
