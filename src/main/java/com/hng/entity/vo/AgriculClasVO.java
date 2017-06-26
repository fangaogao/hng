package com.hng.entity.vo;

import com.hng.entity.AgriculClas;

public class AgriculClasVO {
	private Integer clasId;
	private Integer parentId;
	private String clasName;
	private String levelCode;
	private String clasIcom;
	private String clasImage;
	private String parentName;
	private String status;
	
	public AgriculClasVO() {
		super();
	}
	
	public AgriculClasVO(AgriculClas clas,Integer parentId) {
		super();
		this.clasId = clas.getClasId();
		this.setParentId(parentId);
		this.clasName = clas.getClasName();
		this.levelCode = clas.getLevelCode();
		this.clasIcom = clas.getClasIcom();
		this.clasImage = clas.getClasImage();
		this.parentName = clas.getParentName();
		this.status = clas.getStatus();
	}
	
	public AgriculClasVO(Integer clasId, Integer parentId,
			String clasName, String levelCode, String clasIcom,
			String clasImage, String parentName, String status) {
		super();
		this.clasId = clasId;
		this.setParentId(parentId);
		this.clasName = clasName;
		this.levelCode = levelCode;
		this.clasIcom = clasIcom;
		this.clasImage = clasImage;
		this.parentName = parentName;
		this.status = status;
	}
	public Integer getClasId() {
		return clasId;
	}
	public void setClasId(Integer clasId) {
		this.clasId = clasId;
	}
	public String getClasName() {
		return clasName;
	}
	public void setClasName(String clasName) {
		this.clasName = clasName;
	}
	public String getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	public String getClasIcom() {
		return clasIcom;
	}
	public void setClasIcom(String clasIcom) {
		this.clasIcom = clasIcom;
	}
	public String getClasImage() {
		return clasImage;
	}
	public void setClasImage(String clasImage) {
		this.clasImage = clasImage;
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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	
}
