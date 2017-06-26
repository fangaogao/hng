package com.hng.entity.vo;

import com.hng.entity.City;
import com.hng.entity.Company;
import com.hng.entity.Member;
import com.hng.entity.Users;

public class MemberVO {

	private Integer memberId;
	private Integer cityByAreaId;
	private Integer cityByProvinceId;
	private Integer companyId;
	private Integer userId;
	private String loginName;
	private Integer cityByCityId;
	private String memberName;
	private String companyName;
	private String headImg;
	private String email;
	private String phone;
	private String qq;
	private String address;
	private String memberStatus;
	private String certificationStatus;
	private String idNumber;
	private String identityImg;
	private String identitystatus;
	
	private String completeAddress;//地址全名

	public MemberVO() {
		super();
	}
	
	public MemberVO(Member m,City c1,City c2,City c3,Company com,Users user) {
		super();
		this.memberId = m.getMemberId();
		this.cityByAreaId = c3!=null?c3.getCityId():null;
		this.cityByProvinceId = c1!=null?c1.getCityId():null;
		this.companyId = com!=null?com.getCompanyId():null;
		this.userId = user!=null?user.getUserId():null;
		this.cityByCityId = c2!=null?c2.getCityId():null;
		this.memberName = m.getMemberName();
		this.companyName = m.getCompanyName();
		this.headImg = m.getHeadImg();
		this.email = m.getEmail();
		this.phone = m.getPhone();
		this.qq = m.getQq();
		this.address = m.getAddress();
		this.memberStatus = m.getMemberStatus();
		this.certificationStatus = m.getCertificationStatus();
		this.idNumber = m.getIdNumber();
		this.identityImg = m.getIdentityImg();
		this.identitystatus = m.getIdentitystatus();
		
		this.loginName = user!=null?user.getLoginName():"";
		this.completeAddress = (c1!=null?c1.getCityName():"") + (c2!=null?c2.getCityName():"")
					+(c3!=null?c3.getCityName():"")+(m.getAddress()!=null?m.getAddress():"");
	}
	
	public MemberVO(Integer memberId, Integer cityByAreaId,
			Integer cityByProvinceId, Integer companyId, Integer userId,
			String loginName, Integer cityByCityId, String memberName,
			String companyName, String headImg, String email, String phone,
			String qq, String address, String memberStatus,
			String certificationStatus, String idNumber, String identityImg,
			String identitystatus, String completeAddress) {
		super();
		this.memberId = memberId;
		this.cityByAreaId = cityByAreaId;
		this.cityByProvinceId = cityByProvinceId;
		this.companyId = companyId;
		this.userId = userId;
		this.loginName = loginName;
		this.cityByCityId = cityByCityId;
		this.memberName = memberName;
		this.companyName = companyName;
		this.headImg = headImg;
		this.email = email;
		this.phone = phone;
		this.qq = qq;
		this.address = address;
		this.memberStatus = memberStatus;
		this.certificationStatus = certificationStatus;
		this.idNumber = idNumber;
		this.identityImg = identityImg;
		this.identitystatus = identitystatus;
		this.completeAddress = completeAddress;
	}

	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCityByCityId() {
		return cityByCityId;
	}
	public void setCityByCityId(Integer cityByCityId) {
		this.cityByCityId = cityByCityId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
	public String getCertificationStatus() {
		return certificationStatus;
	}
	public void setCertificationStatus(String certificationStatus) {
		this.certificationStatus = certificationStatus;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getIdentityImg() {
		return identityImg;
	}
	public void setIdentityImg(String identityImg) {
		this.identityImg = identityImg;
	}
	public String getIdentitystatus() {
		return identitystatus;
	}
	public void setIdentitystatus(String identitystatus) {
		this.identitystatus = identitystatus;
	}




	public String getCompleteAddress() {
		return completeAddress;
	}




	public void setCompleteAddress(String completeAddress) {
		this.completeAddress = completeAddress;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	
	
}
