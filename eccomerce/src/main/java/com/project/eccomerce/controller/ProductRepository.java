package com.project.eccomerce.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.eccomerce.model.Product;
import java.lang.String;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, String> {
	 
	 List<Product> listarProductId(String id);
}
