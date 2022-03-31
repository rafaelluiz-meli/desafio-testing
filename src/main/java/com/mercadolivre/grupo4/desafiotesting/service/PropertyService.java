package com.mercadolivre.grupo4.desafiotesting.service;

import com.mercadolivre.grupo4.desafiotesting.model.District;
import com.mercadolivre.grupo4.desafiotesting.model.Property;
import com.mercadolivre.grupo4.desafiotesting.model.PropertyDTO;
import com.mercadolivre.grupo4.desafiotesting.model.Room;
import com.mercadolivre.grupo4.desafiotesting.repository.DistrictRepository;
import com.mercadolivre.grupo4.desafiotesting.repository.PropertyRepository;
import com.mercadolivre.grupo4.desafiotesting.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
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
//        BigDecimal propertyValue = BigDecimal.valueOf(calculateTotalArea(propertyId)).multiply(district.getValuePerSquareMeter());
        return null;
    }

    public Double calculateTotalArea(long propertyId) {
        Property property = propertyRepository.findById(propertyId).get();
//        Double totalArea = property.getRoomList().stream().map(Room::squareMeters).reduce(0.0, Double::sum);
        return null;
    }

    public Room findBiggestRoom(Long propertyId) {
        Property property = propertyRepository.findById(propertyId).get();
//        Room biggestRoom = property.getRoomList().stream().max(Comparator.comparing(Room::squareMeters)).get();
        return null;
    }

    public List<Room> calculateAllRoomArea(long propertyId) {

        Optional<Property> propertyOptional = propertyRepository.findById(propertyId);
        if(propertyOptional.isPresent()) {
            Property property = propertyOptional.get();
            roomRepository.findAllByProperty(property.getId()).get().forEach(
                    room -> {
                        roomRepository.delete(room);
                        room.setArea(room.squareMeters());
                        roomRepository.save(room);
                    }
            );

            return roomRepository.findAllByProperty(propertyId).get();
        }


        return null;
    }

    public Property createProperty(PropertyDTO property) {
        Property createdProperty = propertyRepository.save(new Property(0L, property.getName(), property.getDistrict()));
        List<Room> roomList = property.getRoomList();

        roomList.forEach(room -> {
            room.setProperty(createdProperty.getId());
            roomRepository.save(room);
        });

        return createdProperty;
    }

    public PropertyDTO findProperty(Long propertyId) {

        Optional<Property> propertyOptional = propertyRepository.findById(propertyId);
        Optional<List<Room>> roomOptional = roomRepository.findAllByProperty(propertyId);

        if(propertyOptional.isPresent() && roomOptional.isPresent()) {

            return PropertyDTO.converter(propertyOptional.get(), roomOptional.get());
        }

        return null;
    }
}

