package com.mercadolivre.grupo4.desafiotesting.repository;

import com.mercadolivre.grupo4.desafiotesting.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

}
