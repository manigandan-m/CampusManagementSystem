package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "address")
public class Address {
	
	@Id	
    @Column(name = "address_id")
	private int addressId;
	
	@Column(name = "house_number")
	private String houseNumber;
	
	@Column(name = "street_name")
	private String streetName;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "pincode")
	private int pincode;
	
	public Address() {
	}	

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}	
	
	public Address(String houseNumber, String streetName, String city, String state, String country, int pincode) {
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

}
