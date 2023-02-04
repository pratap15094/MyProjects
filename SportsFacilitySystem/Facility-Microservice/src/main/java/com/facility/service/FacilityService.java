package com.facility.service;

import java.util.List;

import com.facility.entity.FacilityEntity;

public interface FacilityService {

	FacilityEntity create(FacilityEntity facility);

	List<FacilityEntity> getAll();

	FacilityEntity get(Integer id);
}
