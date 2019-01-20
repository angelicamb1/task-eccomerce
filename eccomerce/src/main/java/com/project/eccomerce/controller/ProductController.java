package com.project.eccomerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.eccomerce.model.Product;
import com.project.eccomerce.model.ShoppingCart;
import com.project.eccomerce.repository.CommerceItemRepository;
import com.project.eccomerce.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository repositoryProd;
	@Autowired
	private CommerceItemRepository repositoryComItem;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> listProducts() {
		return repositoryProd.findAll();
	}
	
	@RequestMapping(value = "/shoppingcart", method = RequestMethod.GET)
	public ShoppingCart listShoppingCart() {
		return new ShoppingCart();
	}
	
	@RequestMapping(value = "/shoppingcart/items/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable String id) {
			repositoryComItem.deleteById(id);
			return ResponseEntity.ok().build();
	}
	
	

}
