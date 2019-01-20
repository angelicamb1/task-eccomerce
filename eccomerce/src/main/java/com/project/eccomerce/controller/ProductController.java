package com.project.eccomerce.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.eccomerce.model.CommerceItem;

@RestController
public class ProductController {
	
	private List<CommerceItem> items;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	  public ResponseEntity<List<CommerceItem>> listarEntity() {
	    return new ResponseEntity<List<CommerceItem>>(new ArrayList<CommerceItem>(), HttpStatus.OK);
	  }
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ResponseEntity<CommerceItem> buscarEntity(@PathVariable("id") Integer id) {
	  CommerceItem product = items.get(id);
	 
	  if (product == null) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	 
      return new ResponseEntity<CommerceItem>(HttpStatus.OK);
	}
	
//	private final ProductRepository repository;
//	
//	public ProductController(ProductRepository repository) {
//		this.repository = repository;
//	}
//
//	@GetMapping("/product")
//	List<Product> all() {
//		return repository.findAll();	
//	}

}
