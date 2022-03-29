package com.mercadolivre.grupo4.desafiotesting;

import com.mercadolivre.grupo4.desafiotesting.repository.IPropertyRepository;
import com.mercadolivre.grupo4.desafiotesting.service.PropertyService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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
}
