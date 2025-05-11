package com.cts.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDto {
	
	/*
	 * public CartRequestDto(int quantity2, long productId2, int i) {
	 * 
	 * }
	 */
	private Integer quantity;
    private Long productId;
    private Long userId;
}
