package com.project.eccomerce.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.eccomerce.model.CommerceItem;
import com.project.eccomerce.model.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, List<CommerceItem>> {

}
