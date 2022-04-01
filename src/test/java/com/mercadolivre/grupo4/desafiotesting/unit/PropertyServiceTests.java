package com.mercadolivre.grupo4.desafiotesting.unit;

import com.mercadolivre.grupo4.desafiotesting.exception.PropertyNotFound;
import com.mercadolivre.grupo4.desafiotesting.model.District;
import com.mercadolivre.grupo4.desafiotesting.model.Property;
import com.mercadolivre.grupo4.desafiotesting.model.Room;
import com.mercadolivre.grupo4.desafiotesting.repository.DistrictRepository;
import com.mercadolivre.grupo4.desafiotesting.repository.PropertyRepository;
import com.mercadolivre.grupo4.desafiotesting.repository.RoomRepository;
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
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTests {

    @Mock
    PropertyRepository propertyRepository;

    @Mock
    DistrictRepository districtRepository;
    @Mock
    RoomRepository roomRepository;

    @InjectMocks
    PropertyService propertyService;

    @BeforeEach
    public void init() {
        propertyService = new PropertyService(propertyRepository, districtRepository, roomRepository);
    }

    // arrange
    final District district = new District(1L, "Osasco", BigDecimal.valueOf(1000));
    final Room room1 = new Room(1L, "Quarto", 10.00,10.00,null);
    final Room room2 = new Room(2L, "Sala", 20.00, 10.00, null);
    final Room room3 = new Room(3L, "Banheiro", 5.00, 6.00, null);
    final List<Room> rooms = new ArrayList<>(Arrays.asList(room1,room2, room3));
    final Property property = new Property(1L,"Apartamento", district, rooms);
    final Property propertyNull = new Property();
    final Optional<Property> propertyOptional = Optional.of(property);
    final Optional<Property> propertyOptionalNull = Optional.empty();


    @Test
    @DisplayName("Should calculate property value")
    public void calculatePropertyValue(){

        // Act
        Mockito.when(propertyRepository.findById(anyLong())).thenReturn(propertyOptional);
        BigDecimal propertyValue = propertyService.calculatePropertyValue(anyLong());
        // Assert
        assertEquals(BigDecimal.valueOf(330000.0),propertyValue);
    }

    @Test
    @DisplayName("Should return true if the calculus is wrong")
    public void calculatePropertyValueWrong(){

        // Act
        Mockito.when(propertyRepository.findById(anyLong())).thenReturn(propertyOptional);
        BigDecimal propertyValue = propertyService.calculatePropertyValue(anyLong());
        // Assert
        assertNotEquals(BigDecimal.valueOf(30000.0),propertyValue);
    }

    @Test
    @DisplayName("Should calculate property area.")
    public void totalAreaCalculator() {

        Mockito.when(propertyRepository.findById(any())).thenReturn(propertyOptional);

        //Exec: Excutar o método que iremos testar.
        Double result = propertyService.calculateTotalArea(1L);

        //Assert: Verificar resultados.
        assertEquals(330, result);
    }

    @Test
    @DisplayName("Should return the biggest room")
    public void shouldReturnBiggestRoom(){

        //Act(Executar)
        Mockito.when(propertyRepository.findById(anyLong())).thenReturn(propertyOptional);
        Room biggestRoom = propertyService.findBiggestRoom(anyLong());

        //Assert(Verificar)
        assertEquals(room2, biggestRoom);
    }

    @Test
    @DisplayName("Should not return the biggest room")
    public void shouldNotReturnBiggestRoom(){

        //Act(Executar)
        Mockito.when(propertyRepository.findById(anyLong())).thenReturn(propertyOptional);
        Room biggestRoom = propertyService.findBiggestRoom(anyLong());

        //Assert(Verificar)
        assertNotEquals(room1, biggestRoom);
    }

    @Test
    @DisplayName("Should return a list with rooms and its size")
    public void shouldReturnAListWithRoomsWithSize() {

        //Act(Executar)
        Mockito.when(propertyRepository.findById(anyLong())).thenReturn(propertyOptional);
        List<Room> roomsWithCalculatedArea = propertyService.calculateAllRoomArea(anyLong());

        //Assert(Verificar)
        assertEquals(roomsWithCalculatedArea.get(0).getArea(), 100);
        assertEquals(roomsWithCalculatedArea.get(1).getArea(), 200);
        assertEquals(roomsWithCalculatedArea.get(2).getArea(), 30);
    }

    @Test
    @DisplayName("Should return error when property not found")
    public void shouldReturnErrorWhenPropertyNotFound(){

        //Act
        Mockito.when(propertyRepository.findById(anyLong())).thenReturn(propertyOptionalNull);

        //Assert
        assertThrows(PropertyNotFound.class,
                () -> {
                    propertyService.calculateAllRoomArea(10l);
                });

    }

    @Test
    @DisplayName("Should create a property")
    public void shouldCreateAProperty(){

        //Act(Executar)
        Mockito.when(propertyRepository.save(any())).thenReturn(property);
        Property savedProperty = propertyService.createProperty(any());

        //Assert(Verificar)
        assertEquals(property, savedProperty);
    }

    @Test
    @DisplayName("Should try to Find a Property by Id.")
    public void shouldTryToFindAPropertyById(){

        //Act
        Mockito.when(propertyRepository.findById(any())).thenReturn(propertyOptional);
        Property findedProperty = propertyService.findByPropertyId(anyLong());

        //Assert
        assertEquals(propertyOptional.get(), findedProperty);
    }
}
