package com.mercadolivre.grupo4.desafiotesting.service;

import com.mercadolivre.grupo4.desafiotesting.model.District;
import com.mercadolivre.grupo4.desafiotesting.model.Property;
import com.mercadolivre.grupo4.desafiotesting.model.Room;
import com.mercadolivre.grupo4.desafiotesting.repository.IPropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class PropertyService {
    private final IPropertyRepository propertyRepository;

    public BigDecimal getValue(Long id) {
        Property property = propertyRepository.findById(id);
        District district = property.getDistrict();
        return null;
    }

    public Double totalArea(long propertyId) {
        Property property = propertyRepository.findById(propertyId);
        return property.getRoomList().stream().map(Room::squareMeters).reduce(0.0, Double::sum);
    }
}

