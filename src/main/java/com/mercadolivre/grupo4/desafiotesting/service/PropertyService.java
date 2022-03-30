package com.mercadolivre.grupo4.desafiotesting.service;

import com.mercadolivre.grupo4.desafiotesting.model.District;
import com.mercadolivre.grupo4.desafiotesting.model.Property;
import com.mercadolivre.grupo4.desafiotesting.model.Room;
import com.mercadolivre.grupo4.desafiotesting.repository.IPropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PropertyService {
    private final IPropertyRepository propertyRepository;


    public BigDecimal calculatePropertyValue(Long propertyId) {
        District district = propertyRepository.findById(propertyId).getDistrict();
        BigDecimal propertyValue = BigDecimal.valueOf(totalArea(propertyId)).multiply(district.getValuePerSquareMeter());
        return propertyValue;
    }

    public Double calculateTotalArea(long propertyId) {
        Property property = propertyRepository.findById(propertyId);
        Double totalArea = property.getRoomList().stream().map(Room::squareMeters).reduce(0.0, Double::sum);
        return totalArea;
    }
  
    public Room findBiggestRoom(Long propertyId) {
        Property property = propertyRepository.findById(propertyId);
        Room biggestRoom = property.getRoomList().stream().max(Comparator.comparing(Room::squareMeters)).get();
        return biggestRoom;
    }
}

