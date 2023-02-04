package com.facility.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facility.entity.FacilityEntity;
import com.facility.exception.ResourceNotFoundException;
import com.facility.repository.FacilityRepository;

@Service
public class FacilityServiceImpl implements FacilityService {

		@Autowired
		private FacilityRepository facilityRepository;
		
		
		@Override
		public FacilityEntity create(FacilityEntity facilityEntity) {
			return facilityRepository.save(facilityEntity);
		}

		@Override
		public List<FacilityEntity> getAll() {
			return facilityRepository.findAll();
		}

		@Override
		public FacilityEntity get(Integer id) {
			return facilityRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Facility not found"));
		}

}
