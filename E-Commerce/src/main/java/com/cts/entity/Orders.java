package com.cts.entity;
//import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
    private long orderId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	private double totalPrice;
	private String shippingAddress;
	
	@Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    
}
