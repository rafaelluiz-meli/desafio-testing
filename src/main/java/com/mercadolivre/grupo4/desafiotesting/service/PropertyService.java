package com.mercadolivre.grupo4.desafiotesting.service;

import com.mercadolivre.grupo4.desafiotesting.model.Property;
import com.mercadolivre.grupo4.desafiotesting.model.Room;
import com.mercadolivre.grupo4.desafiotesting.repository.IPropertyRepository;
import com.mercadolivre.grupo4.desafiotesting.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PropertyService {
    private final IPropertyRepository propertyRepository;

    public Room biggestRoom(Long id) {

        Property property = propertyRepository.findById(id);

        return property.getRoomList().stream().max(Comparator.comparing(Room::squareMeters)).get();
    }
}

