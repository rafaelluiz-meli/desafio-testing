package com.mercadolivre.grupo4.desafiotesting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    private Long id;
    private String name;
    private District district;
    private List<Room> roomList;
}
