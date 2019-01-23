package com.project.eccomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.eccomerce.model.CommerceItem;
import com.project.eccomerce.model.Product;

public interface CommerceItemRepository extends JpaRepository<CommerceItem, String>{

	CommerceItem findFirstByProductId(Product productId);

}
