package com.cts.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDto {
	private Long cartItemId;
    private Integer quantity;
    private Double totalPrice;
    private String productName;
    private Double productPrice;
}
