package com.mercadolivre.grupo4.desafiotesting.service;

import com.mercadolivre.grupo4.desafiotesting.model.Property;
import com.mercadolivre.grupo4.desafiotesting.model.Room;
import com.mercadolivre.grupo4.desafiotesting.repository.IPropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropertyService {
    private final IPropertyRepository propertyRepository;

    public Double totalArea(long propertyId) {
        Property property = propertyRepository.findById(propertyId);
        return property.getRoomList().stream().map(Room::squareMeters).reduce(0.0, Double::sum);
    }
}

