package com.mercadolivre.grupo4.desafiotesting.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolivre.grupo4.desafiotesting.model.Property;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PropertyRepository implements IPropertyRepository {
    private final String JSON_PATH = "src/main/resources/property-repository.json";

    private void save(List<Property> propertyList) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(JSON_PATH), propertyList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Property> findAll() {
        List<Property> result = new ArrayList<>();
        try{
            byte[] mapData = Files.readAllBytes(Paths.get(this.JSON_PATH));
            Property[] properties = null;
            ObjectMapper objectMapper = new ObjectMapper();
            properties = objectMapper.readValue(mapData, Property[].class);
            result = new ArrayList<>(Arrays.asList(properties));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Property findById(Long id) {
        List<Property> allResult = this.findAll();
        Optional<Property> result = allResult.stream().filter(property -> property.getId().equals(id)).findFirst();
        if(result.isPresent()){
            return result.get();
        } else {
            // TODO: 29/03/22 CRIAR TRATATIVA DE EXCEÇÃO
            throw new RuntimeException("Produto não existe");
        }
    }

    @Override
    public Property add(Property property) {
        try {
            List<Property> propertyList = this.findAll();
            propertyList.add(property);
            this.save(propertyList);
            return property;
        } catch (Exception ex) {
            // TODO: 29/03/22 CRIAR TRATATIVA DE EXCEÇÃO
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Property remove(Property property) {
        return null;
     }
}
