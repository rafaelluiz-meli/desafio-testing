package com.mercadolivre.grupo4.desafiotesting.controller;

import com.mercadolivre.grupo4.desafiotesting.model.Room;
import com.mercadolivre.grupo4.desafiotesting.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
@AllArgsConstructor
public class PropertyController {
    private final PropertyService propertyService;

    @GetMapping("/biggestRoom/{propertyId}")
    public ResponseEntity<Room> biggestRoom(@PathVariable Long propertyId) {
        Room room = propertyService.findBiggestRoom(propertyId);
        return ResponseEntity.ok().body(room);
    }

    @GetMapping("/value/{propertyId}")
    public ResponseEntity<BigDecimal> getPropertyValue(@PathVariable Long propertyId){
        BigDecimal propertyValue = propertyService.calculatePropertyValue(propertyId);
        return ResponseEntity.ok().body(propertyValue);
    }
    @GetMapping("/totalArea/{propertyId}")
    public ResponseEntity<Double> getTotalArea(@PathVariable Long propertyId) {
        Double totalArea = propertyService.calculateTotalArea(propertyId);
        return ResponseEntity.ok().body(totalArea);
    }

    @GetMapping("/allRoomsArea/{propertyId}")
    public ResponseEntity<List<Room>> getAllRoomsArea(@PathVariable Long propertyId) {
        List<Room> roomList = propertyService.calculateAllRoomArea(propertyId);
        return ResponseEntity.ok().body(roomList);
    }

}
