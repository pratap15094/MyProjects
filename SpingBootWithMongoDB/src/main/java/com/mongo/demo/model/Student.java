package com.mongo.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="student")
public class Student {

	private Integer id;
	private String name;
	private String city;
	private String collage;
	public Student(Integer id, String name, String city, String collage) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.collage = collage;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCollage() {
		return collage;
	}
	public void setCollage(String collage) {
		this.collage = collage;
	}
	
	
}
