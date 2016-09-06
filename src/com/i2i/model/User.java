package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

import com.i2i.model.Role;
import com.i2i.model.Address;

@Entity
@Table(name= "user")
public class User {
	
	@Id
    @Column(name = "user_id")
	private int userId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "blood_group")
	private String bloodGroup;
	
	@Column(name = "mobile_number")
	private long mobileNumber;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id")    
    private Role role;

	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")    
    private Address address;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public User() {
		
	}
    
    public User(String username, String firstName, String lastName, String gender, String bloodGroup, long mobileNumber, Role role, Address address) {
        this.username = username;        
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.mobileNumber = mobileNumber;
        this.role = role;
        this.address = address;        
    }
    
    public User(String username, String password, String firstName, String lastName, String gender, String bloodGroup, long mobileNumber) {
        this.username = username; 
        this.password =password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.mobileNumber = mobileNumber;
        
              
    }
	
}
