package com.mercadolivre.grupo4.desafiotesting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // TODO: 29/03/22 Improve regex for capital letters only
    @NotBlank(message = "O nome da propriedade não pode estar vazio.")
//    @Pattern(regexp="(([A-Z][a-záàâãéèêíïóôõöúçñ]+)\\s).+", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private District district;

//    Solução do Mauri
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "property_id", nullable = false)
    private List<Room> roomList;

//    @NotEmpty(message = "Room list should not be empty")
//    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Room> roomList;
}
