package com.user.dto;

public class FacilityDto {
private int facilityId;
	
	private String facilityName;
	
	private String facilityCategory;
	
	private String facilityStartTime;
	
	private String facilityEndTime;

	public FacilityDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacilityDto(int facilityId, String facilityName, String facilityCategory, String facilityStartTime,
			String facilityEndTime) {
		super();
		this.facilityId = facilityId;
		this.facilityName = facilityName;
		this.facilityCategory = facilityCategory;
		this.facilityStartTime = facilityStartTime;
		this.facilityEndTime = facilityEndTime;
	}

	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getFacilityCategory() {
		return facilityCategory;
	}

	public void setFacilityCategory(String facilityCategory) {
		this.facilityCategory = facilityCategory;
	}

	public String getFacilityStartTime() {
		return facilityStartTime;
	}

	public void setFacilityStartTime(String facilityStartTime) {
		this.facilityStartTime = facilityStartTime;
	}

	public String getFacilityEndTime() {
		return facilityEndTime;
	}

	public void setFacilityEndTime(String facilityEndTime) {
		this.facilityEndTime = facilityEndTime;
	}
}
