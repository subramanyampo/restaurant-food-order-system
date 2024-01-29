package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.items;
import com.example.entity.user;
//import com.example.entity.user;
//import com.example.entity.userregister;
import com.example.entity.userregister;

public interface userrepository extends JpaRepository<userregister,Integer> {
	userregister findByNameAndPassword(String name, String password);
	//List<items>findAll();


}
