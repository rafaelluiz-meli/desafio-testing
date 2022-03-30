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
import static org.mockito.ArgumentMatchers.anyLong;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

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
    @DisplayName("Should calculate property value")
    public void calculatePropertyValue(){
        // Arrange
        Room room = new Room("Cozinha", 10.0, 10.0);
        Room room1 = new Room("Banheiro", 5.0, 5.0);
        Room room2 = new Room("Quarto", 15.0, 15.0);
        Property property = new Property(1L, "Mansao",
                new District("Embu",BigDecimal.valueOf(100)),
                Arrays.asList(room, room1, room2));
        // Act
        Mockito.when(propertyRepository.findById(anyLong())).thenReturn(property);
        BigDecimal propertyValue = propertyService.calculatePropertyValue(anyLong());
        // Assert
        assertEquals(propertyValue,BigDecimal.valueOf(35000.0));
    }

    @Test
    @DisplayName("Should return true if the calculus is wrong")
    public void calculatePropertyValueWrong(){
        // Arrange
        Room room = new Room("Cozinha", 10.0, 10.0);
        Room room1 = new Room("Banheiro", 5.0, 5.0);
        Room room2 = new Room("Quarto", 15.0, 15.0);
        Property property = new Property(1L, "Mansao",
                new District("Embu",BigDecimal.valueOf(0)),
                Arrays.asList(room, room1, room2));
        // Act
        Mockito.when(propertyRepository.findById(anyLong())).thenReturn(property);
        BigDecimal propertyValue = propertyService.calculatePropertyValue(anyLong());
        // Assert
        assertNotEquals(propertyValue,BigDecimal.valueOf(35000.0));
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
        Double result = propertyService.calculateTotalArea(1L);

        //Assert: Verificar resultados.
        assertEquals(350, result);
    }

    @DisplayName("Should return the biggest room")
    public void shouldReturnBiggestRoom(){
        //Arrange (Preparar)
        District district = new District("Osasco", new BigDecimal(300.00));

        Room room1 = new Room("Quarto", 10.00,10.00);
        Room room2 = new Room("Sala", 20.00, 10.00);
        Room room3 = new Room("Banheiro", 5.00, 6.00);

        List<Room> rooms = new ArrayList<>(Arrays.asList(room1,room2, room3));

        Property property = new Property(1L,"Apartamento", district, rooms);

        //Act(Executar)
        Mockito.when(propertyRepository.findById(anyLong())).thenReturn(property);
        Room biggestRoom = propertyService.findBiggestRoom(anyLong());

        //Assert(Verificar)
        assertEquals(room2, biggestRoom);
    }

    @Test
    @DisplayName("Should not return the biggest room")
    public void shouldNotReturnBiggestRoom(){
        //Arrange (Preparar)
        District district = new District("Osasco", new BigDecimal(300.00));
        Room room1 = new Room("Quarto", 10.00,10.00);
        Room room2 = new Room("Sala", 20.00, 10.00);
        Room room3 = new Room("Banheiro", 5.00, 6.00);

        List<Room> rooms = new ArrayList<>(Arrays.asList(room1,room2, room3));

        Property property = new Property(1L,"Apartamento", district, rooms);

        //Act(Executar)
        Mockito.when(propertyRepository.findById(anyLong())).thenReturn(property);
        Room biggestRoom = propertyService.findBiggestRoom(anyLong());

        //Assert(Verificar)
        assertNotEquals(room1, biggestRoom);
    }
    
}
