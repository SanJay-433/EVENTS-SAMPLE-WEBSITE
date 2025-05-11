package com.cts.DataTransferObject;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartSummaryDto {
	private List<CartResponseDto> cartItems;
    private Integer totalQuantity;    
    private Double totalPrice;     
}
