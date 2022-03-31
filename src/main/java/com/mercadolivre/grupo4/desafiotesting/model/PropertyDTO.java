package com.mercadolivre.grupo4.desafiotesting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDTO {
    @NotBlank(message = "O nome da propriedade não pode estar vazio.")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    private String name;

    private District district;

    @NotEmpty(message = "Room list should not be empty")
    private List<Room> roomList;

    public static PropertyDTO converter(Property property, List<Room> roomList) {
        return new PropertyDTO(property.getName(), property.getDistrict(), roomList);
    }
}
