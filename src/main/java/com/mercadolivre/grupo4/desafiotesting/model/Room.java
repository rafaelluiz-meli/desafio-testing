package com.mercadolivre.grupo4.desafiotesting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @NotEmpty
    @NotBlank(message = "O campo não pode estar vazio.")
    @Pattern(regexp="(([A-Z][a-záàâãéèêíïóôõöúçñ]+)\\s).+", message = "O campo deve começar com uma letra maiúscula.")
    @Size(max = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres.")
    private String name;

    @NotNull(message = "A largura do cômodo não pode estar vazia.")
    @Max(value = 25, message = "A largura máxima permitida por cômodo é de 25 metros.")
    private Double width;
    @NotNull(message = "O comprimento do cômodo não pode estar vazia")
    @Max(value = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    private Double length;

    private Double area;

    public Double squareMeters() {
        return this.width * this.length;
    }

    public Room(@NotEmpty @NotBlank(message = "O campo não pode estar vazio.") @Pattern(regexp = "(([A-Z][a-záàâãéèêíïóôõöúçñ]+)\\s).+", message = "O campo deve começar com uma letra maiúscula.") @Size(max = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres.") String name, @NotNull(message = "A largura do cômodo não pode estar vazia.") @Max(value = 25, message = "A largura máxima permitida por cômodo é de 25 metros.") Double width, @NotNull(message = "O comprimento do cômodo não pode estar vazia") @Max(value = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros.") Double length) {
        this.name = name;
        this.width = width;
        this.length = length;
    }
}
