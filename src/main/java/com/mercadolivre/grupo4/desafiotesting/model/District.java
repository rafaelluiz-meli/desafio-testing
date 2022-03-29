package com.mercadolivre.grupo4.desafiotesting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {
    private String name;
    private BigDecimal valuePerSquareMeter;
    private Double length;
    private Double width;
}
