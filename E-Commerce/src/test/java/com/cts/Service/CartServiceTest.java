package com.cts.Service;

import com.cts.DataTransferObject.CartRequestDto;
import com.cts.DataTransferObject.CartResponseDto;
import com.cts.DataTransferObject.CartSummaryDto;
import com.cts.Repository.CartRepository;
import com.cts.Repository.ProductRepository;
import com.cts.Repository.UserRepository;
import com.cts.entity.Cart;
import com.cts.entity.Product;
import com.cts.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class CartServiceTest {

    @Mock
    private CartRepository cartRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private UserRepository userRepository;
    
    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private CartService cartService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddShoppingCart() {
        // Arrange
        CartRequestDto cartRequestDto = new CartRequestDto(2, 1L, 1L);
        Product product = new Product(1L,"Sanjay","dfgg",50.0,10L,"mob","mi","hj",true);
        User user = new User(1L,"Sanjay", "San@gmail.com", "12345", "123 street,Navalur", "Credit card");
        Cart cart = new Cart(1L, 2, 100.0, product, user);
        CartResponseDto cartResponseDto = new CartResponseDto(1L,2,100.0,"Sanjay",50.0);
        
        
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);
        when(modelMapper.map(cart, CartResponseDto.class)).thenReturn(cartResponseDto); // Mock ModelMapper behavior

        // Act
        CartResponseDto response = cartService.addShoppingCart(cartRequestDto);

        // Assert
		 assertNotNull(response);
	     assertEquals(1L, response.getCartItemId());
	     assertEquals(2,response.getQuantity());
	     assertEquals(100.0,response.getTotalPrice());
			 

        verify(cartRepository, times(1)).save(any(Cart.class));
    }

	
	  @Test 
	  void testGetAllShoppingCartsForUser() 
	  { 
	// Arrange 
		 User user = new User(1L,"Sanjay","San@gmail.com","12345","123 street,Navalur","Credit card");
	     Product product = new Product(1L,"Product1","asdfghjk",50.0,10L,"Mobile","mi","asdfghj", true); 
	     Cart cart = new Cart( 1L,2, 100.0, product, user);
	     CartResponseDto cartResponsedto = new CartResponseDto(1L,2,100.0,"Product1",50.0);
	    
	    when(cartRepository.findAll()).thenReturn(Arrays.asList(cart));
	    when(modelMapper.map(cart, CartResponseDto.class)).thenReturn(cartResponsedto);

	  // Act
         CartSummaryDto summary = cartService.getAllShoppingCartsForUser(1L);
         
         
	  // Assert 
	     assertNotNull(summary);
                      
	     assertEquals(1, summary.getCartItems().size());
	     assertEquals(100.0,summary.getTotalPrice());
	     assertEquals(2, summary.getTotalQuantity());
	  }
	  
		
		  @Test 
		  void testUpdateShoppingCart() 
		  { 
		  // Arrange 
			  CartRequestDto cartRequestDto = new CartRequestDto(5, 1L, 1L);
			  Product product = new Product(1L, "Product1","asdfghjk", 50.0,10L,"Mobile","mi","asdfghj", true); 
			  User user = new User(1L,"Sanjay","San@gmail.com","12345","123 street,Navalur","Credit card"); 
			  Cart cart = new Cart(1L,2,100.0,product,user);
		  
		  when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));
		  when(productRepository.findById(1L)).thenReturn(Optional.of(product));
		  when(cartRepository.save(any(Cart.class))).thenReturn(cart);
		  
		  // Act 
		  CartResponseDto response = cartService.updateShoppingCart(1L,cartRequestDto);
		  
		  // Assert 
		  assertNotNull(response);
		  
		  assertEquals(1L, response.getCartItemId()); 
		  assertEquals(50.0,response.getTotalPrice());
		  
		  verify(cartRepository, times(1)).save(any(Cart.class)); 
		  
		  }
		  
		  @Test void testDeleteShoppingCart() 
		  { 
			  // Arrange 
			  User user = new User(1L,"Sanjay","San@gmail.com","12345","123 street,Navalur","Credit card"); 
			  Product product = new Product(1L,"Product1","asdfghjk",50.0,10L,"Mobile","mi","asdfghj", true);
		      Cart cart = new Cart(1L,2,100.0,product,user);
		  
		      when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));
		  
		      cartService.deleteShoppingCart(1L, 1L);
		  
		      verify(cartRepository, times(1)).delete(cart); 
		  }
		 	 
}