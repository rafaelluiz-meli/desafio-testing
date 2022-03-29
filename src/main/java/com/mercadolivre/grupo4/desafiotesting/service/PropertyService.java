package com.mercadolivre.grupo4.desafiotesting.service;

import com.mercadolivre.grupo4.desafiotesting.repository.IPropertyRepository;
import com.mercadolivre.grupo4.desafiotesting.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropertyService {
    private final IPropertyRepository propertyRepository;
}

