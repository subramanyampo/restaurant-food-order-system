package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.admin;

public interface adminrepository extends JpaRepository<admin,Integer>{
	public abstract admin findByNameAndPassword(String name,String password);

}
