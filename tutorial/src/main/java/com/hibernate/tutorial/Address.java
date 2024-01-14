package com.hibernate.tutorial;


import java.util.*;
import java.util.Date;


import jakarta.persistence.*;

@Entity
@Table(name = "Employee_address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-increment primary key by 1
	@Column(name = "address_id")	//to change the column name
	private int addressId;
	
	@Column(length = 50, name ="STREET")
	private String Street;
	
	@Column(length = 50, name="CITY")
	private String city;
	
	private boolean isOpen;
	
	@Transient //Table of this variable/field will not be created, all other columns withoud @transient will be created automatically
	private double x;
	
	@Temporal(TemporalType.DATE)
	private Date addedDate;
	
	@Lob //to store large object
	private byte[] image; //byte array to store images
	
	
	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getStreet() {
		return Street;
	}


	public void setStreet(String street) {
		Street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public boolean isOpen() {
		return isOpen;
	}


	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}


	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public Date getAddedDate() {
		return addedDate;
	}


	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Address(int addressId, String street, String city, boolean isOpen, double x, Date addedDate, byte[] image) {
		super();
		this.addressId = addressId;
		Street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.x = x;
		this.addedDate = addedDate;
		this.image = image;
	}


	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", Street=" + Street + ", city=" + city + ", isOpen=" + isOpen
				+ ", x=" + x + ", image=" + Arrays.toString(image) + "]";
	}
	
	
}
