package com.mercadolivre.grupo4.desafiotesting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private String name;
    private Double width;
    private Double length;

    public Double squareMeters() {
        return this.width * this.length;
    }
}
