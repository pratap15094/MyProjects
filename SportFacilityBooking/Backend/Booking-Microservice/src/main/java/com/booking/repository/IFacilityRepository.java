package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entity.Facility;

public interface IFacilityRepository extends JpaRepository<Facility,Integer>{

}
