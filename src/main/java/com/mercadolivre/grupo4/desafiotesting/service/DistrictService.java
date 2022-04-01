package com.mercadolivre.grupo4.desafiotesting.service;

import com.mercadolivre.grupo4.desafiotesting.exception.DistrictAlreadyExists;
import com.mercadolivre.grupo4.desafiotesting.model.District;
import com.mercadolivre.grupo4.desafiotesting.repository.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DistrictService {

    private final DistrictRepository districtRepository;

    public District createDistrict(District district) {
        districtExists(district.getName());
        District district1 = districtRepository.save(district);
        return district1;
    }

    public boolean districtExists(String nameDistrict) {
        Optional<District> district = districtRepository.findByName(nameDistrict);
        if (district.isEmpty()) {
            return false;
        }

        throw new DistrictAlreadyExists(nameDistrict);
    }
}
