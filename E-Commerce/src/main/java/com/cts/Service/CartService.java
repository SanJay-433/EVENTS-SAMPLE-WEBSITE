package com.cts.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.DataTransferObject.CartRequestDto;
import com.cts.DataTransferObject.CartResponseDto;
import com.cts.DataTransferObject.CartSummaryDto;
import com.cts.Repository.CartRepository;
import com.cts.Repository.ProductRepository;
import com.cts.Repository.UserRepository;
import com.cts.entity.Cart;
import com.cts.entity.Product;
import com.cts.entity.User;

@Service
public class CartService {
	

	    @Autowired
	    private CartRepository cartRepository;

	    @Autowired
	    private ProductRepository productRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private ModelMapper modelMapper;

	    // Get all cart items for a specific user with total quantity and price
	    public CartSummaryDto getAllShoppingCartsForUser(Long userId)
	    {
	        List<CartResponseDto> cartItems = cartRepository.findAll().stream()
	                .filter(cart -> cart.getUser().getUserId().equals(userId))
	                .map(cart -> modelMapper.map(cart, CartResponseDto.class))
	                .collect(Collectors.toList());

	        int totalQuantity = cartItems.stream().mapToInt(cartItem -> cartItem.getQuantity()).sum();
	        double totalPrice = cartItems.stream().mapToDouble(cartItem -> cartItem.getTotalPrice()).sum();

	        CartSummaryDto summary = new CartSummaryDto();
	        summary.setCartItems(cartItems);
	        summary.setTotalQuantity(totalQuantity);
	        summary.setTotalPrice(totalPrice);

	        return summary;
	    }

	    // Add an item to the cart
	    public CartResponseDto addShoppingCart(CartRequestDto cartRequestDTO) 
	    {
	        Cart cart = new Cart();
	        cart.setQuantity(cartRequestDTO.getQuantity());

	        Product product = productRepository.findById(cartRequestDTO.getProductId())
	                .orElseThrow(() -> new RuntimeException("Product not found"));
	        User user = userRepository.findById(cartRequestDTO.getUserId())
	                .orElseThrow(() -> new RuntimeException("User not found"));
	        
			
			  if (!product.getAvailable()) { throw new
			  RuntimeException("Product is not available for adding to the cart"); }
			 
	        
	        cart.setProduct(product);
	        cart.setUser(user);
	        cart.setTotalPrice(cartRequestDTO.getQuantity() * product.getPrice());
            
	        Cart savedCart = cartRepository.save(cart);
	        return modelMapper.map(savedCart, CartResponseDto.class);
            
	        
	    }

	    // Update an item in the cart
	    public CartResponseDto updateShoppingCart(Long cartItemId, CartRequestDto cartRequestDTO) 
	    {
	        return cartRepository.findById(cartItemId)
	                .filter(cart -> cart.getUser().getUserId().equals(cartRequestDTO.getUserId()))
	                .map(cart -> {
	                    Product product = productRepository.findById(cartRequestDTO.getProductId())
	                            .orElseThrow(() -> new RuntimeException("Product not found"));

	                    cart.setQuantity(cartRequestDTO.getQuantity());
	                    cart.setTotalPrice(cartRequestDTO.getQuantity() * product.getPrice());
	                    cart.setProduct(product);

	                    Cart updatedCart = cartRepository.save(cart);

	                    return modelMapper.map(updatedCart, CartResponseDto.class);
	                })
	                .orElseThrow(() -> new RuntimeException("Cart item not found or access denied"));
	    }

	    // Remove an item from the cart
	    public void deleteShoppingCart(Long cartItemId, Long userId) 
	    {
	        cartRepository.findById(cartItemId)
	                .filter(cart -> cart.getUser().getUserId().equals(userId))
	                .ifPresentOrElse(cartRepository::delete,
	                        () -> { throw new RuntimeException("Cart item not found or access denied"); });
	    }
	}
	
	
	
	
	
	
	

	/*
	 * @Autowired private CartRepository cartRepository;
	 * 
	 * // Get all cart items for a specific user public List<Cart>
	 * getAllShoppingCartsForUser(Long userId) { return
	 * cartRepository.findAll().stream() .filter(cart ->
	 * cart.getUser().getUserId().equals(userId)) .collect(Collectors.toList()); }
	 * 
	 * // Add an item to the cart public Cart addShoppingCart(Cart cart) { //
	 * Calculate the total price based on quantity and product price
	 * cart.setTotalPrice(cart.getQuantity() * cart.getProduct().getPrice()); return
	 * cartRepository.save(cart); }
	 * 
	 * // Update an item in the cart public Cart updateShoppingCart(Long cartItemId,
	 * Cart updatedCart) { return cartRepository.findById(cartItemId) .filter(cart
	 * -> cart.getUser().getUserId().equals(updatedCart.getUser().getUserId()))
	 * .map(cart -> { cart.setQuantity(updatedCart.getQuantity());
	 * cart.setTotalPrice(updatedCart.getQuantity() *
	 * updatedCart.getProduct().getPrice());
	 * cart.setProduct(updatedCart.getProduct()); return cartRepository.save(cart);
	 * }) .orElseThrow(() -> new
	 * RuntimeException("Cart item not found or access denied")); }
	 * 
	 * // Remove an item from the cart public void deleteShoppingCart(Long
	 * cartItemId, Long userId) { cartRepository.findById(cartItemId) .filter(cart
	 * -> cart.getUser().getUserId().equals(userId))
	 * .ifPresentOrElse(cartRepository::delete, () -> { throw new
	 * RuntimeException("Cart item not found or access denied"); }); }
	 */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	/*
	 * @Autowired private CartRepository cartRepository;
	 * 
	 * public List<Cart> getAllShoppingCarts() { return cartRepository.findAll(); }
	 * 
	 * public Optional<Cart> getShoppingCartById(Long id) { return
	 * cartRepository.findById(id); }
	 * 
	 * public Cart addShoppingCart(Cart shoppingCart) { return
	 * cartRepository.save(shoppingCart); }
	 * 
	 * 
	 * public Cart updateShoppingCart(Long id, Cart updatedShoppingCart) { return
	 * cartRepository.findById(id).map(cart -> {
	 * cart.setUser(updatedShoppingCart.getUser()); return
	 * cartRepository.save(cart); }).orElseThrow(() -> new
	 * RuntimeException("ShoppingCart not found with id " + id)); }
	 * 
	 * 
	 * public void deleteShoppingCart(Long id) { cartRepository.deleteById(id); }
	 */


