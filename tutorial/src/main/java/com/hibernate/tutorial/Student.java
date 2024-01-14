package com.hibernate.tutorial;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//Consider this class as a table -> (Entity) -> Added class name in config.xml properties
//@Entity-> For marking this class to behave as an entity, mhnje "Student_data" navacha table create honar
@Entity(name="Student_data")
public class Student {

	//@Id ->for marking any column for primary key (will represent a 'PRIMARY KEY')
	@Id 
	private int id;
	
	private String name;
	private String city;
	
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
}
