package com.skillstorm.inventory_management_system.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.inventory_management_system.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
