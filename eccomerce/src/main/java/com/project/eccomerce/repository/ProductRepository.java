package com.project.eccomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.eccomerce.model.Product;
import java.lang.String;



public interface ProductRepository extends JpaRepository<Product, String> {
	 
}
