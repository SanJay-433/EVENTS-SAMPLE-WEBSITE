package com.cts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
	/*
	 * public Cart(int quantity, double totalPrice, Product product, User user) {
	 * this.quantity=quantity; this.totalPrice=totalPrice; this.product=product;
	 * this.user=user; }
	 */

	@Id 
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Long cartItemId;
      private Integer quantity;
      private Double totalPrice;
      
      @ManyToOne
      @JoinColumn(name="productId")
      private Product product;
      
      @ManyToOne
      @JoinColumn(name="userId")
      private User user;
      
      
      
}
