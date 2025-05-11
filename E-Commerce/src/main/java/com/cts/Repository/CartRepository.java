package com.cts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.entity.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{


}

