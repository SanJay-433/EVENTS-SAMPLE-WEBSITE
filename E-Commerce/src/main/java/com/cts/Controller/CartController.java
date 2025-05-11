package com.cts.Controller;

import com.cts.entity.Cart;
import com.cts.DataTransferObject.CartRequestDto;
import com.cts.DataTransferObject.CartResponseDto;
import com.cts.DataTransferObject.CartSummaryDto;
import com.cts.Service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
    private CartService cartService;


	    // Get all cart items for a specific user with total quantity and price
	    @GetMapping("/user/{userId}")
	    public CartSummaryDto getAllShoppingCartsForUser(@PathVariable Long userId) {
	        return cartService.getAllShoppingCartsForUser(userId);
	    }

	    // Add an item to the cart
	    @PostMapping
	    public CartResponseDto addShoppingCart(@RequestBody CartRequestDto cartRequestDTO) {
	        return cartService.addShoppingCart(cartRequestDTO);
	    }

	    // Update an item in the cart
	    @PutMapping("/{cartItemId}")
	    public ResponseEntity<CartResponseDto> updateShoppingCart(@PathVariable Long cartItemId, @RequestBody CartRequestDto cartRequestDTO) {
	        try {
	            return ResponseEntity.ok(cartService.updateShoppingCart(cartItemId, cartRequestDTO));
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Remove an item from the cart
	    @DeleteMapping("/{cartItemId}/user/{userId}")
	    public ResponseEntity<String> deleteShoppingCart(@PathVariable Long cartItemId, @PathVariable Long userId) {
	        try {
	            cartService.deleteShoppingCart(cartItemId, userId);
	            return ResponseEntity.ok("Shopping cart item deleted successfully");
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
	
	
	
	
	/*
	 * // Get all cart items for a specific user
	 * 
	 * @GetMapping("/user/{userId}") public List<Cart>
	 * getAllShoppingCartsForUser(@PathVariable Long userId) { return
	 * cartService.getAllShoppingCartsForUser(userId); }
	 * 
	 * // Add an item to the cart
	 * 
	 * @PostMapping public Cart addShoppingCart(@RequestBody Cart cart) { return
	 * cartService.addShoppingCart(cart); }
	 * 
	 * // Update an item in the cart
	 * 
	 * @PutMapping("/{cartItemId}") public ResponseEntity<Cart>
	 * updateShoppingCart(@PathVariable Long cartItemId, @RequestBody Cart
	 * updatedCart) { try { return
	 * ResponseEntity.ok(cartService.updateShoppingCart(cartItemId, updatedCart)); }
	 * catch (RuntimeException e) { return ResponseEntity.notFound().build(); } }
	 * 
	 * // Remove an item from the cart
	 * 
	 * @DeleteMapping("/{cartItemId}/user/{userId}") public ResponseEntity<String>
	 * deleteShoppingCart(@PathVariable Long cartItemId, @PathVariable Long userId)
	 * { try { cartService.deleteShoppingCart(cartItemId, userId); return
	 * ResponseEntity.ok("Shopping cart item deleted successfully"); } catch
	 * (RuntimeException e) { return ResponseEntity.notFound().build(); } }
	 */	
	
	/*
	 * @Autowired private CartService cartService;
	 * 
	 * @GetMapping public List<Cart> getAllShoppingCarts() { return
	 * cartService.getAllShoppingCarts(); }
	 * 
	 * @GetMapping("/{id}") public ResponseEntity<Cart>
	 * getShoppingCartById(@PathVariable Long id) { return
	 * cartService.getShoppingCartById(id) .map(ResponseEntity::ok)
	 * .orElse(ResponseEntity.notFound().build()); }
	 * 
	 * @PostMapping public Cart addShoppingCart(@RequestBody Cart shoppingCart) {
	 * return cartService.addShoppingCart(shoppingCart); }
	 * 
	 * 
	 * 
	 * @PutMapping("/{id}") public ResponseEntity<Cart>
	 * updateShoppingCart(@PathVariable Long id, @RequestBody Cart updatedCart) {
	 * try { return ResponseEntity.ok(cartService.updateShoppingCart(id,
	 * updatedCart)); } catch (RuntimeException e) { return
	 * ResponseEntity.notFound().build(); } }
	 * 
	 * 
	 * @DeleteMapping("/{id}") public ResponseEntity<String>
	 * deleteShoppingCart(@PathVariable Long id) {
	 * cartService.deleteShoppingCart(id); return
	 * ResponseEntity.ok("Shopping cart deleted successfully"); }
	 */
}