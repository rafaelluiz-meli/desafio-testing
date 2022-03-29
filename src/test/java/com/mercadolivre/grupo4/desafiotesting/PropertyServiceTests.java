package com.mercadolivre.grupo4.desafiotesting;

import com.mercadolivre.grupo4.desafiotesting.model.District;
import com.mercadolivre.grupo4.desafiotesting.model.Property;
import com.mercadolivre.grupo4.desafiotesting.model.Room;
import com.mercadolivre.grupo4.desafiotesting.repository.IPropertyRepository;
import com.mercadolivre.grupo4.desafiotesting.service.PropertyService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

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
    public void shouldReturnBigRoom(){
        //Arrange (Preparar)
        District district = new District("Osasco", new BigDecimal(300.00));

        Room room1 = new Room("Quarto", 10.00,10.00);
        Room room2 = new Room("Sala", 20.00, 10.00);
        Room room3 = new Room("Banheiro", 5.00, 6.00);

        List<Room> rooms = new ArrayList<>(Arrays.asList(room1,room2, room3));

        Property property = new Property(1L,"Apartamento", district, rooms);

        //Act(Executar)

            Mockito.when(propertyRepository.findById(anyLong())).thenReturn(property);
            Room bigRoom = propertyService.biggestRoom(1L);

        //Assert(Verificar)
            assertEquals(room2, bigRoom);
    }
    
}
