package com.mercadolivre.grupo4.desafiotesting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do bairro não pode estar vazio.")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    private String name;

    @NotBlank(message = "Valor do metro quadrado do bairro não pode estar vazio.")
    @DecimalMax(value = "9999999999999", message = "O comprimento do valor por metro quadrado não deve exceder 13 dígitos")
    private BigDecimal valuePerSquareMeter;

}
