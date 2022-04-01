package com.mercadolivre.grupo4.desafiotesting.unit;

import com.mercadolivre.grupo4.desafiotesting.exception.DistrictAlreadyExists;
import com.mercadolivre.grupo4.desafiotesting.model.District;
import com.mercadolivre.grupo4.desafiotesting.repository.DistrictRepository;
import com.mercadolivre.grupo4.desafiotesting.service.DistrictService;
import com.mercadolivre.grupo4.desafiotesting.service.PropertyService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class DistrictServiceTest {

    @Mock
    DistrictRepository districtRepository;

    @InjectMocks
    DistrictService districtService;

    //Arrange
    District district = new District(1l, "Vila Rafael", BigDecimal.valueOf(5.0));
    Optional<District> districtOption = Optional.of(district);
    Optional<District> districtOptionEmpty = Optional.empty();


    @Test
    @DisplayName("Should return false when trying to create one existing district")
    public void shouldReturnFalseWhenTryingToCreateOneNewDistrict(){

        //Act
        Mockito.when(districtRepository.findByName(any())).thenReturn(districtOptionEmpty);
        Boolean districtExists = districtService.districtExists(district.getName());

        //Assert
        assertEquals(false, districtExists);
    }

    @Test
    @DisplayName("Should return error when trying to create one new district")
    public void shouldReturnErrorWhenTryingToCreateOneNewDistrict(){

        //Act
        Mockito.when(districtRepository.findByName(any())).thenReturn(districtOption);

        //Assert
        assertThrows(DistrictAlreadyExists.class, () -> {
            districtService.districtExists(district.getName());
        });

    }

    @Test
    @DisplayName("Should create a new district")
    public void shouldCreateNewDistrict(){

        //Act
        Mockito.when(districtRepository.save(any())).thenReturn(district);
        District saveDistrict = districtService.createDistrict(district);
        //Assert
        assertEquals(district, saveDistrict);
    }
}


