package com.cts.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	
	public Product(String name, String description, double price, long stockQuantity, String category, String brand, String imageUrl,
			boolean available) {
		this.name = name;
	    this.description = description;
	    this.price = price;
	    this.stockQuantity = stockQuantity;
	    this.category = category;
	    this.brand = brand;
	    this.imageUrl = imageUrl;
	    this.available = available;
	}
	@Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Long productId;
	  
      private String name;
      private String description;
      private Double price;
      private Long stockQuantity;
      private String category;
      private String brand;
      private String imageUrl;
      private Boolean available;

      
      
	
      
      

}
