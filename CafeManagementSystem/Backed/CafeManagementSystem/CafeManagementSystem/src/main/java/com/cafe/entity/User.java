package com.cafe.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import lombok.Data;

@NamedQuery(name = "User.findByEmailId", query = "select u from User u where u.email=:email")

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "CAFE-USERS")
public class User implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private String email;
	private String password;
	private Boolean status;
	private String role;
	private String contacetNumber;

}
