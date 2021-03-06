package com.project.eccomerce.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@SessionScope
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class ShoppingCart {
	
	//@XmlElementWrapper(name = "items", required = true)
    //@XmlElement(name = "item")
	private List<CommerceItem> items;
	//@XmlElement
	private BigDecimal amount;
	
	public ShoppingCart() {
		super();
	}
	
	@JsonProperty
	public List<CommerceItem> getItems() {
		return items;
	}
	
	public void setItems(List<CommerceItem> items) {
		this.items = items;
	}
	
	@JsonProperty
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public ShoppingCart(List<CommerceItem> items, BigDecimal amount) {
		super();
		this.items = items;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ShoppingCart [items=" + items + ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCart other = (ShoppingCart) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}
}
