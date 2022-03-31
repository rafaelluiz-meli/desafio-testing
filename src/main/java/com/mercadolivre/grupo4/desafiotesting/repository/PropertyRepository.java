package com.mercadolivre.grupo4.desafiotesting.repository;

import com.mercadolivre.grupo4.desafiotesting.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

}
