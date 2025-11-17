package com.skillstorm.inventory_management_system.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.inventory_management_system.Models.Product;
import com.skillstorm.inventory_management_system.Models.Warehouse;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
    //QUERIES Database for a list of products containing a particular name, case insensitive
    public List<Product> findByNameContainingIgnoreCase(String name);

}
