package com.mercadolivre.grupo4.desafiotesting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    private Long id;
    // TODO: 29/03/22 Improve regex for capital letters only
    @NotBlank(message = "O nome da propriedade não pode estar vazio.")
    @Pattern(regexp="(([A-Z][a-záàâãéèêíïóôõöúçñ]+)\\s).+", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    private String name;

    @NotBlank
    private District district;

    @NotEmpty(message = "Room list should not be empty")
    private List<Room> roomList;
}
