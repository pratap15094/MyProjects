package com.facility.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facility.entity.FacilityEntity;
import com.facility.service.FacilityService;


@RestController
@RequestMapping("/facilitys")
public class FacilityController {

	@Autowired
	private FacilityService facilityService;
	
	@PostMapping
	public ResponseEntity<FacilityEntity> createHotel(@RequestBody FacilityEntity facilityEntity){
		return ResponseEntity.status(HttpStatus.CREATED).body(facilityService.create(facilityEntity));
		
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<FacilityEntity> createHotel(@PathVariable Integer Id){
		return ResponseEntity.status(HttpStatus.OK).body(facilityService.get(Id));
		
	}
	
	@GetMapping
	public ResponseEntity<List<FacilityEntity>> getAll(){
		return ResponseEntity.ok(facilityService.getAll());
	}
}
