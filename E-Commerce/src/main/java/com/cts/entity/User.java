package com.cts.entity;

import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
          public User(String userName, String email, String password, String shippingAddress, String paymentDetails) {
      	    this.userName= userName;
      	    this.email = email;
      	    this.password= password;
      	    this.shippingAddress = shippingAddress;
      	    this.paymentDetails = paymentDetails;
      	    
          }
		@Id
          @GeneratedValue(strategy=GenerationType.IDENTITY)
          private Long userId;
          
          private String userName;
          
          @Column(unique = true)
          private String email;
          private String password;
          private String shippingAddress;
          private String paymentDetails;
} 
