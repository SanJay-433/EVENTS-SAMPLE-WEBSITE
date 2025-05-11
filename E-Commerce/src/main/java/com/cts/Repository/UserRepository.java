package com.cts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cts.entity.User;
public interface UserRepository extends JpaRepository<User,Long>{

     
}
