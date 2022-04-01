package com.mercadolivre.grupo4.desafiotesting.repository;

import com.mercadolivre.grupo4.desafiotesting.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

//    Optional<Room> findByProperty(Long propertyId);

//    Optional<List<Room>> findAllByProperty(Long propertyId);
}
