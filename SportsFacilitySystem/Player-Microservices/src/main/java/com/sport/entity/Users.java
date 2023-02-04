package com.sport.entity;

import java.beans.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQuery(name = "Users.findByEmailId", query = "select u from Users u where u.email=:email")

@NamedQuery(name = "Users.getAllUser", query = "select new com.sport.wrapper.UserWrapper(u.id,u.name,u.address,u.state,u.country,u.email,u.pan,u.contactNumber,u.dob) from Users u where u.role='user'")

//@NamedQuery(name = "Users.updateStatus", query = "update Users u set u.status=:status where u.id=:id")

//@NamedQuery(name = "Users.getAllAdmin", query = "select u.email from Users u where u.role='admin'")



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "SPORT-PLAYER")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String address;
	private String state;
	private String country;
	private String email;
	private String pan;
	private String contactNumber;
	private String dob;
	
	private String password;
	private String status;
	private String role;
	
	
	@javax.persistence.Transient
	private List<Booking> bookings = new ArrayList<>();
	
	
}