package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String Restaurantname;
	String place;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRestaurantname() {
		return Restaurantname;
	}
	public void setRestaurantname(String restaurantname) {
		Restaurantname = restaurantname;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	

}
