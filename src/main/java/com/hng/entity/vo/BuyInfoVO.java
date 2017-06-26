package com.hng.entity.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.hng.entity.AgriculClas;
import com.hng.entity.BuyInfo;
import com.hng.entity.City;
import com.hng.entity.Member;

public class BuyInfoVO {
	private Integer buyId;
	private Integer cityByAreaId;
	private Integer cityByProvinceId;
	private Integer memberId;
	private Integer agriculClasId;
	private Integer cityByCityId;
	private String buyTitle;
	private Double minQuantity;
	private Double maxQuantity;
	private String quantityUnit;
	private Double minPrice;
	private Double maxPrice;
	private String address;
	private String description;
	private String contacts;
	private String phone;
	private String qq;
	private String email;
	private String publishDate;
	private Integer expiryInterval;
	private String expiryDate;
	private Integer accessTimes;
	private Integer collectTimes;
	private String status;
	
	private long interval;
	
	private String memberName;
	private String agriculClasName;
	private String completeAddress;//地址全名
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public BuyInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BuyInfoVO(BuyInfo info) {
		super();
		this.buyId = info.getBuyId();
		this.buyTitle = info.getBuyTitle();
		this.minQuantity = info.getMinQuantity();
		this.maxQuantity = info.getMaxQuantity();
		this.quantityUnit = info.getQuantityUnit();
		this.minPrice = info.getMinPrice();
		this.maxPrice = info.getMaxPrice();
		this.address = info.getAddress();
		this.description = info.getDescription();
		this.contacts = info.getContacts();
		this.phone = info.getPhone();
		this.qq = info.getQq();
		this.email = info.getEmail();
		this.publishDate = info.getPublishDate()!=null?df.format(info.getPublishDate()):"";
		this.expiryInterval = info.getExpiryInterval();
		this.expiryDate = info.getExpiryDate()!=null?df.format(info.getExpiryDate()):"";
		this.accessTimes = info.getAccessTimes();
		this.collectTimes = info.getCollectTimes();
		this.status = info.getStatus();
	}
	
	public BuyInfoVO(BuyInfo info,City c1,City c2,City c3,Member m,AgriculClas clas) {
		super();
		this.buyId = info.getBuyId();
		this.cityByAreaId = c3.getCityId();
		this.cityByProvinceId = c1.getCityId();
		this.memberId = m.getMemberId();
		this.agriculClasId = clas.getClasId();
		this.cityByCityId = c2.getCityId();
		this.buyTitle = info.getBuyTitle();
		this.minQuantity = info.getMinQuantity();
		this.maxQuantity = info.getMaxQuantity();
		this.quantityUnit = info.getQuantityUnit();
		this.minPrice = info.getMinPrice();
		this.maxPrice = info.getMaxPrice();
		this.address = info.getAddress();
		this.description = info.getDescription();
		this.contacts = info.getContacts();
		this.phone = info.getPhone();
		this.qq = info.getQq();
		this.email = info.getEmail();
		this.publishDate = info.getPublishDate()!=null?df.format(info.getPublishDate()):"";
		this.expiryInterval = info.getExpiryInterval();
		this.expiryDate = info.getExpiryDate()!=null?df.format(info.getExpiryDate()):"";
		this.accessTimes = info.getAccessTimes();
		this.collectTimes = info.getCollectTimes();
		this.status = info.getStatus();
		
		this.memberName = m.getMemberName();
		this.agriculClasName = clas.getClasName();
		this.completeAddress = (c1!=null?c1.getCityName():"") + (c2!=null?c2.getCityName():"")
				+(c3!=null?c3.getCityName():"")+(m.getAddress()!=null?info.getAddress():"");
		if(info.getPublishDate()!=null&&info.getExpiryDate()!=null){
			this.interval = (info.getExpiryDate().getTime()-info.getPublishDate().getTime())/(24*60*60*1000);
		}
	}
	
	public BuyInfoVO(Integer buyId, Integer cityByAreaId,
			Integer cityByProvinceId, Integer memberId, Integer agriculClasId,
			Integer cityByCityId, String buyTitle, Double minQuantity,
			Double maxQuantity, String quantityUnit, Double minPrice,
			Double maxPrice, String address, String description,
			String contacts, String phone, String qq, String email,
			String publishDate, Integer expiryInterval,
			String expiryDate, Integer accessTimes, Integer collectTimes,
			String status, String memberName, String agriculClasName,
			String completeAddress) {
		super();
		this.buyId = buyId;
		this.cityByAreaId = cityByAreaId;
		this.cityByProvinceId = cityByProvinceId;
		this.memberId = memberId;
		this.agriculClasId = agriculClasId;
		this.cityByCityId = cityByCityId;
		this.buyTitle = buyTitle;
		this.minQuantity = minQuantity;
		this.maxQuantity = maxQuantity;
		this.quantityUnit = quantityUnit;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.address = address;
		this.description = description;
		this.contacts = contacts;
		this.phone = phone;
		this.qq = qq;
		this.email = email;
		this.publishDate = publishDate;
		this.expiryInterval = expiryInterval;
		this.expiryDate = expiryDate;
		this.accessTimes = accessTimes;
		this.collectTimes = collectTimes;
		this.status = status;
		this.memberName = memberName;
		this.agriculClasName = agriculClasName;
		this.completeAddress = completeAddress;
	}
	public Integer getBuyId() {
		return buyId;
	}
	public void setBuyId(Integer buyId) {
		this.buyId = buyId;
	}
	public Integer getCityByAreaId() {
		return cityByAreaId;
	}
	public void setCityByAreaId(Integer cityByAreaId) {
		this.cityByAreaId = cityByAreaId;
	}
	public Integer getCityByProvinceId() {
		return cityByProvinceId;
	}
	public void setCityByProvinceId(Integer cityByProvinceId) {
		this.cityByProvinceId = cityByProvinceId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getAgriculClasId() {
		return agriculClasId;
	}
	public void setAgriculClasId(Integer agriculClasId) {
		this.agriculClasId = agriculClasId;
	}
	public Integer getCityByCityId() {
		return cityByCityId;
	}
	public void setCityByCityId(Integer cityByCityId) {
		this.cityByCityId = cityByCityId;
	}
	public String getBuyTitle() {
		return buyTitle;
	}
	public void setBuyTitle(String buyTitle) {
		this.buyTitle = buyTitle;
	}
	public Double getMinQuantity() {
		return minQuantity;
	}
	public void setMinQuantity(Double minQuantity) {
		this.minQuantity = minQuantity;
	}
	public Double getMaxQuantity() {
		return maxQuantity;
	}
	public void setMaxQuantity(Double maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	public String getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public Integer getExpiryInterval() {
		return expiryInterval;
	}
	public void setExpiryInterval(Integer expiryInterval) {
		this.expiryInterval = expiryInterval;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Integer getAccessTimes() {
		return accessTimes;
	}
	public void setAccessTimes(Integer accessTimes) {
		this.accessTimes = accessTimes;
	}
	public Integer getCollectTimes() {
		return collectTimes;
	}
	public void setCollectTimes(Integer collectTimes) {
		this.collectTimes = collectTimes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getAgriculClasName() {
		return agriculClasName;
	}
	public void setAgriculClasName(String agriculClasName) {
		this.agriculClasName = agriculClasName;
	}
	public String getCompleteAddress() {
		return completeAddress;
	}
	public void setCompleteAddress(String completeAddress) {
		this.completeAddress = completeAddress;
	}

	public long getInterval() {
		return interval;
	}

	public void setInterval(long interval) {
		this.interval = interval;
	}

	
}
