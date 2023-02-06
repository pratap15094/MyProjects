package Booking.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Facility implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer facility_id;
	private String facility_name;
	private String description;

	public Facility(Integer facility_id, String facility_name, String description) {
		super();
		this.facility_id = facility_id;
		this.facility_name = facility_name;
		this.description = description;
	}

	public Facility() {
		super();
	}

	public Integer getFacility_id() {
		return facility_id;
	}

	public void setFacility_id(Integer facility_id) {
		this.facility_id = facility_id;
	}

	public String getFacility_name() {
		return facility_name;
	}

	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}