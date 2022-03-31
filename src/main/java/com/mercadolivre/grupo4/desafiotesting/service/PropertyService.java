package com.mercadolivre.grupo4.desafiotesting.service;

import com.mercadolivre.grupo4.desafiotesting.model.District;
import com.mercadolivre.grupo4.desafiotesting.model.Property;
import com.mercadolivre.grupo4.desafiotesting.model.Room;
import com.mercadolivre.grupo4.desafiotesting.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Comparator;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PropertyService {
    private final PropertyRepository propertyRepository;


    public BigDecimal calculatePropertyValue(Long propertyId) {
        District district = propertyRepository.findById(propertyId).get().getDistrict();
        BigDecimal propertyValue = BigDecimal.valueOf(calculateTotalArea(propertyId)).multiply(district.getValuePerSquareMeter());
        return propertyValue;
    }

    public Double calculateTotalArea(long propertyId) {
        Property property = propertyRepository.findById(propertyId).get();
        Double totalArea = property.getRoomList().stream().map(Room::squareMeters).reduce(0.0, Double::sum);
        return totalArea;
    }

    public Room findBiggestRoom(Long propertyId) {
        Property property = propertyRepository.findById(propertyId).get();
        Room biggestRoom = property.getRoomList().stream().max(Comparator.comparing(Room::squareMeters)).get();
        return biggestRoom;
    }

    public List<Room> calculateAllRoomArea(long propertyId) {

        Optional<Property> propertyOptional = propertyRepository.findById(propertyId);
        if(propertyOptional.isPresent()) {
            Property property = propertyOptional.get();
            property.getRoomList().forEach(
                    room -> room.setArea(room.squareMeters())
            );

            return property.getRoomList();
        }


        return null;
    }

    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    public Property findProperty(Long propertyId) {
        Optional<Property> propertyOptional = propertyRepository.findById(propertyId);

        return propertyOptional.orElse(null);

    }
}

