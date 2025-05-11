package com.cts.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.boot.CommandLineRunner;
import com.cts.Repository.ProductRepository;
import com.cts.entity.Product;
import com.github.javafaker.Faker;

@Configuration
public class AutoConfig {
	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
	
	/*
	 * @Bean public CommandLineRunner seedDatabase(ProductRepository
	 * productRepository) { return args -> { Faker faker = new Faker();
	 * 
	 * // Insert 50 fake products for (int i = 0; i < 50; i++) { Product product =
	 * new Product(); product.setName(faker.commerce().productName()); // Fake
	 * Product Name product.setDescription(faker.lorem().sentence()); // Fake
	 * Description product.setPrice(Double.valueOf(faker.commerce().price())); //
	 * Fake Price product.setStockQuantity((long) faker.number().numberBetween(1,
	 * 100)); // Random Stock product.setCategory(faker.commerce().department()); //
	 * Random Category product.setBrand(faker.company().name()); // Fake Brand
	 * product.setImageUrl(faker.internet().image()); // Random Image URL
	 * //product.setAvailable(faker.bool().bool()); // Random Availability
	 * 
	 * productRepository.save(product); }
	 * 
	 * System.out.println("50 Fake Products Inserted!"); }; }
	 */
	
}

