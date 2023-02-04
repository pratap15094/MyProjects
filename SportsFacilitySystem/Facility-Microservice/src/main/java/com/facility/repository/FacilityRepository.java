package com.facility.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facility.entity.FacilityEntity;

public interface FacilityRepository extends JpaRepository<FacilityEntity, Integer> {

}
