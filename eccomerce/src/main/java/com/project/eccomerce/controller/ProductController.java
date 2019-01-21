package com.project.eccomerce.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.eccomerce.model.CommerceItem;
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
	@Autowired
	private ShoppingCart shoppingCart;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> listProducts() {
		return repositoryProd.findAll();
	}
	
	@RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
	public ResponseEntity<ShoppingCart> listShoppingshoppingCart() {
		return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/shoppingCart/items/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable String id) {
		shoppingCart.getItems().removeIf(item -> item.equals(id));
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/shoppingCart/items", method = RequestMethod.POST)
	public ResponseEntity<CommerceItem> addItemToshoppingCart(@RequestParam("productId") String productId,
			@RequestParam(value = "qtd", defaultValue = "0") int qtd) throws Exception {
		
		CommerceItem commerceItem = repositoryComItem.findFirstByProductId(productId);
		if (commerceItem == null) {
			throw new Exception(String.format("No commerce item found with the productId [ %s ].", productId));
		}
		
		BigDecimal price = commerceItem.getProductId().getPrice();
		for (int i = 0; i <= qtd; i++) {
			if (shoppingCart.getItems() == null) {
				shoppingCart.setItems(new ArrayList<>());
			}
			
			shoppingCart.getItems().add(commerceItem);
			
			if (shoppingCart.getAmount() == null ) {
				shoppingCart.setAmount(price);
			} else {
				shoppingCart.getAmount().add(price);
			}
		}

		return new ResponseEntity<>(commerceItem, HttpStatus.OK);
	}

}
