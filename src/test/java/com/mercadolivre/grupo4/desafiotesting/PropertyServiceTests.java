package com.mercadolivre.grupo4.desafiotesting;

import com.mercadolivre.grupo4.desafiotesting.model.District;
import com.mercadolivre.grupo4.desafiotesting.model.Property;
import com.mercadolivre.grupo4.desafiotesting.model.Room;
import com.mercadolivre.grupo4.desafiotesting.repository.IPropertyRepository;
import com.mercadolivre.grupo4.desafiotesting.service.PropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


import java.math.BigDecimal;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTests {
    @Mock
    IPropertyRepository propertyRepository;

    @InjectMocks
    PropertyService propertyService;

    @BeforeEach
    public void init() {
        propertyService = new PropertyService(propertyRepository);
    }

    @Test
    public void firstTest() {
        assertTrue(true);
    }

    @Test
    @DisplayName("Should calculate property area.")
    public void totalAreaCalculator() {
        //Setup: Configurar o que o teste precisa para rodar.
        Room room = new Room("Cozinha", 10.0, 10.0);
        Room room1 = new Room("Banheiro", 5.0, 5.0);
        Room room2 = new Room("Quarto", 15.0, 15.0);
        District district = new District("Jabaquara", BigDecimal.valueOf(4200));
        Property property = new Property(1L, "Casa", district, Arrays.asList(room, room1, room2));
        Mockito.when(propertyRepository.findById(any())).thenReturn(property);

        //Exec: Excutar o método que iremos testar.
        Double result = propertyService.totalArea(1L);

        //Assert: Verificar resultados.
        assertEquals(350, result);


    }

    @Test
    @DisplayName("Should throw error when property does not exist.")
    public void nonExistentPropertyAreaCalculator() {
        //Setup: Configurar o que o teste precisa para rodar.

        //Exec: Excutar o método que iremos testar.
        RuntimeException e = assertThrows(RuntimeException.class, () -> propertyService.totalArea(any()), "Should throw RuntimeException.");

        //Assert: Verificar resultados.
        assertTrue(e.getMessage().contains("Propriedade não existe."));



    }

}
