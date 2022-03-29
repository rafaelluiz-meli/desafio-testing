package com.mercadolivre.grupo4.desafiotesting.service;

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

    public Room biggestRoom(List<Room> roomList) {
        Double squareSize = 0.0;
        Double tempSquareSize;
        Room bigRoom = new Room();

        for(int i = 0; i < roomList.size();i++){
            tempSquareSize = roomList.get(i).squareMeters();

            if(tempSquareSize > squareSize){
                squareSize = tempSquareSize;
                bigRoom = roomList.get(i);
            }
        }

        return  bigRoom;
    }
}

