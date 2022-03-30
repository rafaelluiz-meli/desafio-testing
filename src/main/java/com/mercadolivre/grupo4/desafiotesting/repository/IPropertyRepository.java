package com.mercadolivre.grupo4.desafiotesting.repository;

import com.mercadolivre.grupo4.desafiotesting.model.Property;

import java.util.List;

public interface IPropertyRepository {
    List<Property> findAll();
    Property findById(Long id);
    Property add(Property property);
    Property remove(Property property);
}
