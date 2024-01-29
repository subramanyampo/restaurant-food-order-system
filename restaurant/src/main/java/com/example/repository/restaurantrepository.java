package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.restaurant;

public interface restaurantrepository extends JpaRepository<restaurant,Integer>{
	

}
