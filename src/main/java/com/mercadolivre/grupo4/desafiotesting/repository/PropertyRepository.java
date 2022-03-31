package com.mercadolivre.grupo4.desafiotesting.repository;

import com.mercadolivre.grupo4.desafiotesting.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
