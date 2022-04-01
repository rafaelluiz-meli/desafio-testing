package com.mercadolivre.grupo4.desafiotesting.service;

import com.mercadolivre.grupo4.desafiotesting.model.District;
import com.mercadolivre.grupo4.desafiotesting.model.Property;
import com.mercadolivre.grupo4.desafiotesting.model.Room;
import com.mercadolivre.grupo4.desafiotesting.repository.DistrictRepository;
import com.mercadolivre.grupo4.desafiotesting.repository.PropertyRepository;
import com.mercadolivre.grupo4.desafiotesting.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PropertyService {
    private final PropertyRepository propertyRepository;
    private final DistrictRepository districtRepository;
    private final RoomRepository roomRepository;


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

            List<Room> roomList = property.getRoomList();

            if(roomList != null && !roomList.isEmpty()) {
                // TODO: 31/03/22 abstrair método para RoomService
                roomList.forEach(room -> {
                    room.setArea(room.squareMeters());
                });

                property.setRoomList(roomList);
                propertyRepository.saveAndFlush(property);
            }

            return property.getRoomList();

        }
        return null;
    }

    public Property createProperty(Property property) {
        Property createdProperty = propertyRepository.save(property);
        return createdProperty;
    }

    public Property findProperty(Long propertyId) {
        return propertyRepository.findById(propertyId).orElse(null);
    }
}

