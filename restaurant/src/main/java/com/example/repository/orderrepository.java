package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.orders;

public interface orderrepository  extends JpaRepository<orders,Integer>{

}
