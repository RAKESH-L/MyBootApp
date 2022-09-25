package com.mybootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybootapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
