package com.hng.entity.vo;

import com.hng.entity.City;

public class CityVO {
	private Integer cityId;
	private String cityName;
	private String levelCode;
	private Integer parentId;
	private String parentName;
	private String status;
	
	
	public CityVO(City city){
		super();
		this.cityId = city.getCityId();
		this.cityName = city.getCityName();
		this.levelCode = city.getCityName();
		this.parentId = city.getParentId();
		this.parentName = city.getParentName();
		this.status = city.getStatus();
	}
	
	public CityVO(Integer cityId, String cityName, String levelCode,
			Integer parentId, String parentName, String status) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.levelCode = levelCode;
		this.parentId = parentId;
		this.parentName = parentName;
		this.status = status;
	}
	public CityVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
