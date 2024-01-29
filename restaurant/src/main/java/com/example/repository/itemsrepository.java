package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.items;

@Repository
public interface itemsrepository extends JpaRepository<items,Integer>{
	public abstract List<items> findAll();
	public abstract List<items>findAllById(int id);
	public abstract items findById(int id);
	public abstract void deleteById(int id);


}
	
