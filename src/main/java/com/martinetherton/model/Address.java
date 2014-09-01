package com.martinetherton.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="T_ADDRESS")
public class Address {


	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long entityId;	
	

	@Column(name="CITY")
	@NotNull
	private String city;
	
	@Column(name="STREET")
	private String street;

	@Column(name="HOUSE_NUMBER")
	private String houseNumber;
	
	@Column(name="POST_CODE")
	private String postCode;
	
	@Column(name="COUNTRY")
	private String country;

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}	
	
	public void setCity(String city) {
		this.city = city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getCountry() {
		return country;
	}

}
