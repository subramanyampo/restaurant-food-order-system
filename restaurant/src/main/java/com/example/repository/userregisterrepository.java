package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.user;
//import com.example.entity.userregister;

public interface userregisterrepository extends JpaRepository<user,Integer>{
	//public abstract user findById(int id);

}
