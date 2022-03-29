package com.mercadolivre.grupo4.desafiotesting.service;

import com.mercadolivre.grupo4.desafiotesting.model.Property;
import com.mercadolivre.grupo4.desafiotesting.model.Room;
import com.mercadolivre.grupo4.desafiotesting.repository.IPropertyRepository;
import com.mercadolivre.grupo4.desafiotesting.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PropertyService {
    private final IPropertyRepository propertyRepository;

    public Room biggestRoom(Long id) {

        Property property = propertyRepository.findById(id);

        Double squareSize = 0.0;
        Double tempSquareSize;
        List<Room> rooms = property.getRoomList();
        Room bigRoom = new Room();

        for (int i = 0; i < rooms.size(); i++) {
            tempSquareSize = rooms.get(i).squareMeters();

            if (tempSquareSize > squareSize) {
                squareSize = tempSquareSize;
                bigRoom = rooms.get(i);
            }
        }

        return bigRoom;
    }
}

